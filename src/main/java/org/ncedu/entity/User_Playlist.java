package org.ncedu.entity;

/**
 * Created by nick on 19.11.16.
 */
public class User_Playlist {
    private Long up_id;

    private Users users;

    private Playlist playlist;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
