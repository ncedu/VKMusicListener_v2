package org.ncedu.dao.impl;

import org.ncedu.dao.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ncedu.entity.*;

import java.util.List;

/**
 * Created by nick on 24.11.16.
 */
@Repository
public class RoomDAOImpl implements RoomDAO {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public List<Rooms> getRoomsByUser(Users user) {
        List<Rooms> result = (List<Rooms>) hibernateTemplate.find("select r from Users u " +
                "join u.user_playlists up " +
                "join up.playlist p " +
                "join p.room r " +
                "where u.user_id = " +
                user.getUser_id());
        return result;
    }

    public void addRoom(Rooms room)
    {
        hibernateTemplate.save(room);
    }
}
