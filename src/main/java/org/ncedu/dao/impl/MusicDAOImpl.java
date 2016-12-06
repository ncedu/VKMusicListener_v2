package org.ncedu.dao.impl;

import org.ncedu.dao.MusicDAO;
import org.ncedu.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 16.11.16.
 */
@Repository
public class MusicDAOImpl implements MusicDAO {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public List<Music> getMusicByRoomId(Long room_id) {
        return (List<Music>) hibernateTemplate.find("select m " +
                "from Playlist p " +
                "join p.music m " +
                "join p.room r " +
                "where r.room_id = " +
                room_id);
    }

    @Override
    public void addMusic(Music music) {
        hibernateTemplate.save(music);
    }

    @Override
    public Music getMusicById(Long id) {
        return hibernateTemplate.get(Music.class, id);
    }
}
