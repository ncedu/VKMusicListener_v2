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

    @Override
    public void addRoom(Rooms room)
    {
        hibernateTemplate.save(room);
    }

    @Override
    public List<Rooms> getRoomsByLink (String link) {
        return (List<Rooms>) hibernateTemplate.find ("select r from Rooms r where r.room_link = \'" + link+"\'");
    }

    @Override
    public List<Long> getCreatorIdRoomByLink(String link) {
        return (List<Long>) hibernateTemplate.find ("select distinct u.user_id from Users u " +
                "join u.user_playlists up " +
                "join up.playlist p " +
                "join p.room r " +
                "where r.room_link = \'" +
                link + "\'" + " and up.isCreatorRoom = 1");
    }

    @Override
    public boolean isUniqueRoomLink(String link) {
        List result = hibernateTemplate.find("select * from Rooms r where r.room_link = ''" + link + "''");
        if (result == null || result.size() == 0) {
            return true;
        } return false;
    }

    //недоделано
    public void deleteRoomByLink(String link)
    {
        //List<Playlist> playlists = (List<Playlist>) hibernateTemplate.find("select p from Playlist p " +
        //        "join p.room r " +
        //        "where r.room_link = \'" +  link + "\'");
        //System.out.println(playlists);
        //hibernateTemplate.delete(getRoomsByLink(link));
    }
}
