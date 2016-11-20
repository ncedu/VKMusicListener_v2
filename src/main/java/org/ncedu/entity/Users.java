package org.ncedu.entity;

import java.sql.Date;
import java.util.Set;

/**
 * Created by nick on 19.11.16.
 */

public class Users {
    private long user_id;

    private String name;

    private String vk_id;

    private Date registration;

    private String access_token;

    private Set<User_Playlist> user_playlists;

    public Users() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVk_id() {
        return vk_id;
    }

    public void setVk_id(String vk_id) {
        this.vk_id = vk_id;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Set<User_Playlist> getUser_playlists() {
        return user_playlists;
    }

    public void setUser_playlists(Set<User_Playlist> user_playlists) {
        this.user_playlists = user_playlists;
    }
}
