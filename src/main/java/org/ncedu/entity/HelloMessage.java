package org.ncedu.entity;

/**
 * Created by nick on 28.11.16.
 */
public class HelloMessage {
    String name;

    public HelloMessage(String name) {
        this.name = name;
    }

    public HelloMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
