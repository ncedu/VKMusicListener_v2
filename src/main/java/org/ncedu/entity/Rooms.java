package org.ncedu.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */
public class Rooms {
    private long room_id;

    private String name;

    private String description;

    private Date created;

    private Set<Playlist> playlists;


    public Rooms() {
    }

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
}
