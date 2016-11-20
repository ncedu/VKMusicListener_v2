package org.ncedu.entity;

import java.sql.Date;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */
public class Playlist {

    private long playlist_id;

    private Rooms rooms;

    private Music music;

    private Date added_date;

    private Set<User_Playlist> user_playlists;

    public Playlist() {
    }

    public long getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }

    public Set<User_Playlist> getUser_playlists() {
        return user_playlists;
    }

    public void setUser_playlists(Set<User_Playlist> user_playlists) {
        this.user_playlists = user_playlists;
    }
}
