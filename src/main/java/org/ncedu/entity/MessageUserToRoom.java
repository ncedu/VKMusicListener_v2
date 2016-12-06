package org.ncedu.entity;

/**
 * Created by Kruchon on 04.12.2016.
 */
public class MessageUserToRoom {
    private String userVkId;
    private String roomLink;

    public String getUserVkId() {
        return userVkId;
    }

    public void setUserVkId(String userVkId) {
        this.userVkId = userVkId;
    }

    public String getRoomLink() {
        return roomLink;
    }

    public void setRoomLink(String roomLink) {
        this.roomLink = roomLink;
    }

    @Override
    public String toString() {
        return "MessageUserToRoom{" +
                "userVkId='" + userVkId + '\'' +
                ", roomLink='" + roomLink + '\'' +
                '}';
    }
}
