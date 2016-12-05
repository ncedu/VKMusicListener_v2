package org.ncedu.dao;

import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomDAO {
    List<Rooms> getRoomsByUser (Users user);
    List<Rooms> getRoomsByLink (String link);
    List<Long> getCreatorIdRoomByLink (String link);
    void addRoom(Rooms room);
    boolean isUniqueRoomLink (String link);
    void deleteRoomByLink(String link);
    List<Users> getUsersByRoomLink(String room_link);
}
