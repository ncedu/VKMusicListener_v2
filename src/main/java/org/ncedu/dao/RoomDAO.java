package org.ncedu.dao;

import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomDAO {
    public List getRoomsByUser (Users user);
}
