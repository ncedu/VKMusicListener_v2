package org.ncedu.entity;

import oracle.sql.BLOB;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */
public class Music {
    private Long music_id;

    private String author;

    private String name;

    private BLOB song;

    private Set<Playlist> playlists;

    public Music() {
    }

    public Long getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Long music_id) {
        this.music_id = music_id;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BLOB getSong() {
        return song;
    }

    public void setSong(BLOB song) {
        this.song = song;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
}
