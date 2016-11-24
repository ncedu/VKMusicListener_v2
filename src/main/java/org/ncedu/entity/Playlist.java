package org.ncedu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */
@Entity
@Table
public class Playlist implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long playlist_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "music_id", nullable = true)
    private Music music_id;
    @Column
    private Date added_date;
    @OneToMany (mappedBy = "playlist_id")
    private Set<User_Playlist> user_playlists;

    public Playlist() {
    }

    public long getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }

    public Rooms getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Rooms rooms) {
        this.room_id = rooms;
    }

    public Music getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Music music_id) {
        this.music_id = music_id;
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
