package org.ncedu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nick on 19.11.16.
 */
@Entity
@Table
public class User_Playlist implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long up_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @Column
    private Integer isCreatorRoom;

    public Integer getIsCreatorRoom() {
        return isCreatorRoom;
    }

    public void setIsCreatorRoom(Integer isCreatorRoom) {
        this.isCreatorRoom = isCreatorRoom;
    }

    public User_Playlist() {
    }

    public Long getUp_id() {
        return up_id;
    }

    public void setUp_id(Long up_id) {
        this.up_id = up_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
