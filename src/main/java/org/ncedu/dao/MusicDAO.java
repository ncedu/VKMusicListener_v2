package org.ncedu.dao;

import org.ncedu.entity.Music;

import java.util.List;

/**
 * Created by nick on 16.11.16.
 */
public interface MusicDAO {
    public List<Music> getMusicByRoomId (Long room_id);
}
