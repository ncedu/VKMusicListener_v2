package org.ncedu.dao;

import org.ncedu.entity.Music;

import java.util.List;

/**
 * Created by nick on 16.11.16.
 */
public interface MusicDAO {
    List<Music> getMusicByRoomId (Long room_id);
    void addMusic (Music music);
    Music getMusicById (Long id);
}
