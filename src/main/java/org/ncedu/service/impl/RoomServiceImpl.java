package org.ncedu.service.impl;

import org.ncedu.dao.RoomDAO;
import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;
import org.ncedu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by nick on 24.11.16.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDAO roomDAO;

    @Transactional
    @Override
    public List<Rooms> getRoomsByUser (Users user) {
        return roomDAO.getRoomsByUser(user);
    }

    @Transactional
    @Override
    public void addRoom(String name, String description)
    {
        Rooms room = new Rooms();
        room.setName(name);
        room.setDescription(description);

        String symbols = "abdefhiknrstyzABDEFGHKNQRSTYZ23456789";
        StringBuilder randLink = new StringBuilder();
        for(int i=0;i<30;i++)
             randLink.append(symbols.charAt((int)(Math.random()*symbols.length())));

        room.setRoom_link(randLink.toString());
        Calendar currenttime = Calendar.getInstance();
        room.setCreated(new Date((currenttime.getTime()).getTime()));
        roomDAO.addRoom(room);
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
}
