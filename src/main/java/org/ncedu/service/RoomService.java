package org.ncedu.service;

import org.ncedu.entity.Users;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
public interface RoomService {
    public List getRoomsByUser (Users user);
}
