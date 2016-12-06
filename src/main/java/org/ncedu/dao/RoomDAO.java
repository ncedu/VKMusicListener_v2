package org.ncedu.dao;

import org.ncedu.entity.Rooms;
import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomDAO {
<<<<<<< HEAD
    public List<Rooms> getRoomsByUser (Users user);
    public List<Rooms> getRoomsByLink (String link);
    public List<Long> getCreatorIdRoomByLink (String link);
    public void addRoom(Rooms room);
    public boolean isUniqueRoomLink (String link);
    public Rooms getRoomsById (Long id);
=======
    List<Rooms> getRoomsByUser (Users user);
    List<Rooms> getRoomsByLink (String link);
    List<Long> getCreatorIdRoomByLink (String link);
    void addRoom(Rooms room);
    boolean isUniqueRoomLink (String link);
    void deleteRoomByLink(String link);
    List<Users> getUsersByRoomLink(String room_link);
>>>>>>> 426aef898b34d42efe5770061b30bab801e6f8f4
}
