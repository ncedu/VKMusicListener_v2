package org.ncedu.service.impl;

import org.ncedu.dao.MusicDAO;
import org.ncedu.entity.Music;
import org.ncedu.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by nick on 16.11.16.
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicDAO musicDAO;

    @Transactional
    @Override
    public Music getMusicById(Long id) {
        return musicDAO.getMusicById(id);
    }

    @Transactional
    @Override
    public List<Music> getMusicByRoom(Long room_id) {
        return musicDAO.getMusicByRoomId(room_id);
    }
}
