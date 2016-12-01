package org.ncedu.service.impl;

import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.http.HttpConnection;
import org.ncedu.dao.MusicDAO;
import org.ncedu.entity.Music;
import org.ncedu.service.VkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by nick on 01.12.16.
 */
@Service
public class VkServiceImpl implements VkService {
    private VkApiClient vkApiClient;
    private TransportClient client;

    @Autowired
    MusicDAO musicDAO;

    public VkServiceImpl () {
        TransportClient client = HttpTransportClient.getInstance();
        vkApiClient = new VkApiClient(client);
    }

    @Transactional
    @Override
    public String getAudio (String link) throws IOException {
        URLConnection connection = new URL(link).openConnection();
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] tmp = new byte[1024];
        int b;
        while ((b = is.read(tmp)) != -1) {
            baos.write(tmp, 0, b);
        }
        /**
         * Test music entity
         */
        Music music = new Music();
        music.setName("test");
        music.setAuthor("test");
        music.setSong(baos.toByteArray());
        musicDAO.addMusic(music);
        is.close();
        return "ok";
    }
}
