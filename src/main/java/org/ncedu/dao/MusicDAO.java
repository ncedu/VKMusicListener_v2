package org.ncedu.dao;

import org.ncedu.entity.Music;

import java.util.List;

/**
 * Created by nick on 16.11.16.
 */
public interface MusicDAO {
<<<<<<< HEAD
    public List<Music> getMusicByRoomId (Long room_id);
    public void addMusic (Music music);
    public Music getMusicById (Long id);

=======
    List<Music> getMusicByRoomId (Long room_id);
    void addMusic (Music music);
    Music getMusicById (Long id);
>>>>>>> 426aef898b34d42efe5770061b30bab801e6f8f4
}
