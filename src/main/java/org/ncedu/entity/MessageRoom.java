package org.ncedu.entity;

/**
 * Created by Kruchon on 24.11.2016.
 */
public class MessageRoom {
    private String name;
    private String description;
    //Это id создателя комнаты
    private String creatorVkId;

    public String getCreator_id() {
        return creatorVkId;
    }

    public void setCreator_id(String creator_id) {
        this.creatorVkId = creator_id;
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

    @Override
    public String toString() {
        return "MessageRoom{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creatorVkId='" + creatorVkId + '\'' +
                '}';
    }
}
