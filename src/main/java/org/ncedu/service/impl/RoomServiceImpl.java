package org.ncedu.service.impl;

import org.ncedu.dao.PlaylistDAO;
import org.ncedu.dao.RoomDAO;
import org.ncedu.dao.UserDAO;
import org.ncedu.dao.UserPlaylistDAO;
import org.ncedu.entity.Playlist;
import org.ncedu.entity.Rooms;
import org.ncedu.entity.User_Playlist;
import org.ncedu.entity.Users;
import org.ncedu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDAO roomDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    PlaylistDAO playlistDAO;

    @Autowired
    UserPlaylistDAO userPlaylistDAO;

    @Transactional
    @Override
    public List<Rooms> getRoomsByUser (Users user) {
        return roomDAO.getRoomsByUser(user);
    }

    @Transactional
    @Override
    public void deleteRoomByLink(String room_link) {
        roomDAO.deleteRoomByLink(room_link);
    }

    @Transactional
    @Override
    public void addRoom(String name, String description, String user_vk_id)
    {
        Rooms room = new Rooms();
        room.setName(name);
        room.setDescription(description);

        String randLink = randLink();
        while (!roomDAO.isUniqueRoomLink(randLink)) {
            randLink = randLink();
        }
        room.setRoom_link(randLink());
        Calendar currenttime = Calendar.getInstance();
        Date createdDate = new Date((currenttime.getTime()).getTime());
        room.setCreated(createdDate);
        roomDAO.addRoom(room);

        Users user = (Users) userDAO.getUserByVk(user_vk_id).get(0);
        Playlist playlist = new Playlist();
        playlist.setMusic(null);
        playlist.setAdded_date(createdDate);
        playlist.setRoom(room);
        playlist.setUser_playlists(null);
        playlistDAO.addPlaylist(playlist);

        User_Playlist user_playlist = new User_Playlist();
        user_playlist.setUser(user);
        user_playlist.setIsCreatorRoom(1);
        user_playlist.setPlaylist(playlist);
        userPlaylistDAO.addUserPlaylist(user_playlist);
    }

    @Transactional
    @Override
    public Rooms getRoomsByLink(String link) {
        return roomDAO.getRoomsByLink(link).get(0);
    }

    @Transactional
    @Override
    public String getCreatorIdRoomsByLink(String link) {
        return "" + roomDAO.getCreatorIdRoomByLink(link).get(0);
    }

    @Transactional
    @Override
    public void addUserToRoom(Users user, Rooms room) {
        Playlist playlist = new Playlist();
        playlist.setMusic(null);
        playlist.setRoom(room);
        playlist.setUser_playlists(null);
        playlist.setAdded_date(new Date(new java.util.Date().getTime()));
        playlistDAO.addPlaylist(playlist);

        User_Playlist user_playlist = new User_Playlist();
        user_playlist.setUser(user);
        user_playlist.setPlaylist(playlist);
        user_playlist.setIsCreatorRoom(0);
        userPlaylistDAO.addUserPlaylist(user_playlist);
    }

    public String randLink () {
        String symbols = "abdefhiknrstyzABDEFGHKNQRSTYZ23456789";
        StringBuilder randLink = new StringBuilder();
        for(int i=0;i<30;i++)
            randLink.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randLink.toString();
    }


    public List<Users> getUsersByRoomLink(String room_link)
    {
        return roomDAO.getUsersByRoomLink(room_link);
    }
}
