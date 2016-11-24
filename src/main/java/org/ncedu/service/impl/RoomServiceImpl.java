package org.ncedu.service.impl;

import org.ncedu.dao.RoomDAO;
import org.ncedu.entity.Users;
import org.ncedu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDAO roomDAO;

    @Transactional
    @Override
    public List getRoomsByUser (Users user) {
        roomDAO.getRoomsByUser(user);
        return null;
    }
}
