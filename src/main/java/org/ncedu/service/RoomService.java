package org.ncedu.service;

import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomService {
    List<Rooms> getRoomsByUser (Users user);
    void addRoom(String name, String description, String user_vk_id);
    Rooms getRoomsByLink (String link);
    String getCreatorIdRoomsByLink (String link);
    void addUserToRoom (Users user, Rooms room);
    void deleteRoomByLink(String room_link);
    List<Users> getUsersByRoomLink(String room_link);
}
