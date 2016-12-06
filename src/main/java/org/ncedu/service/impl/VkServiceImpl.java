package org.ncedu.service.impl;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.audio.AudioFull;
import com.vk.api.sdk.objects.audio.responses.GetResponse;
import com.vk.api.sdk.objects.audio.responses.SearchResponse;
import org.ncedu.dao.*;
import org.ncedu.entity.*;
import org.ncedu.service.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 01.12.16.
 */
@Service
public class VkServiceImpl implements VkService {
    private VkApiClient vkApiClient;
    private TransportClient client;

    @Autowired
    MusicDAO musicDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoomDAO roomDAO;

    @Autowired
    PlaylistDAO playlistDAO;

    @Autowired
    UserPlaylistDAO userPlaylistDAO;

    public VkServiceImpl () {
        TransportClient client = HttpTransportClient.getInstance();
        vkApiClient = new VkApiClient(client);
    }

    @Transactional
    @Override
    public Music getAudio (String uid, String room_id, String link, String name, String author) throws IOException {
        URLConnection connection = new URL(link).openConnection();
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] tmp = new byte[1024];
        int b;
        while ((b = is.read(tmp)) != -1) {
            baos.write(tmp, 0, b);
        }
        baos.flush();
        /**
         * Test music entity
         */
        Music music = new Music();
        music.setName(name);
        music.setAuthor(author);
        music.setSong(baos.toByteArray());
        musicDAO.addMusic(music);
        Users users = (Users) userDAO.getUserByVk(uid).get(0);
        Playlist playlist = new Playlist();
        playlist.setMusic(music);
        playlist.setRoom(roomDAO.getRoomsById(Long.parseLong(room_id)));
        playlist.setAdded_date(new Date(new java.util.Date().getTime()));
        playlistDAO.addPlaylist(playlist);
        User_Playlist up = new User_Playlist();
        up.setUser(users);
        up.setPlaylist(playlist);
        up.setIsCreatorRoom(0);
        userPlaylistDAO.addUserPlaylist(up);
        baos.close();
        is.close();
        return music;
    }

    @Override
    @Transactional
    public MessageMusic[] searchAudio (String uid, String query) throws ClientException, ApiException {
        Users users = (Users) userDAO.getUserByVk(uid).get(0);
        String access_token = users.getAccess_token();
        UserActor actor = new UserActor(Integer.parseInt(uid), access_token);
        SearchResponse getResponse = vkApiClient
                .audio()
                .search(actor)
                .q(query)
                .autoComplete(true)
                .count(30)
                .execute();
        return generateArray(getResponse.getItems());
    }

    @Transactional
    public MessageMusic[] getAudioList (int uid) throws ClientException, ApiException {
        Users users = (Users) userDAO.getUserByVk(String.valueOf(uid));
        String access_token = users.getAccess_token();
        UserActor actor = new UserActor(uid, access_token);
        GetResponse getResponse = vkApiClient
                .audio()
                .get(actor)
                .count(100)
                .execute();
        return generateArray(getResponse.getItems());
    }

    public MessageMusic[] generateArray (List<AudioFull> audioFulls) {
        MessageMusic[] musics = new MessageMusic[audioFulls.size()];
        int i = 0;
        for (AudioFull audio: audioFulls) {
            MessageMusic music = new MessageMusic();
            music.setAuthor(audio.getArtist());
            music.setName(audio.getTitle());
            music.setLink(audio.getUrl());
            musics[i] = music;
            i++;
        }
        return musics;
    }


}
