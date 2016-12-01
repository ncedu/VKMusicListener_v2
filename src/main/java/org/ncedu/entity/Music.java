package org.ncedu.entity;

import oracle.sql.BLOB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */
@Entity
@Table
public class Music implements Serializable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long music_id;
    @Column
    private String author;
    @Column
    private String name;

    @Column
    @Lob
    private byte[] song;

    @OneToMany (mappedBy = "music")
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

    public byte[] getSong() {
        return song;
    }

    public void setSong(byte[] song) {
        this.song = song;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
}
