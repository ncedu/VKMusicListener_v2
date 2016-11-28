package org.ncedu.service;

import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomService {
    public List<Rooms> getRoomsByUser (Users user);

    void addRoom(String name, String description);
    public Rooms getRoomsByLink (String link);
    public String getCreatorIdRoomsByLink (String link);
    public void addUserInRoom (Users user, Rooms room);
}
