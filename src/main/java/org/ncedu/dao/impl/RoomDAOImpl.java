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
    public List getRoomsByUser(Users user) {
        List result = hibernateTemplate.find("from org.ncedu.entity.Rooms r " +
                "where org.ncedu.entity.Playlist in " +
                "(select org.ncedu.entity.User_Playlist " +
                "from org.ncedu.entity.User_Playlist " +
                "where USER_ID = ?)", user.getUser_id());
        return result;
    }
}
