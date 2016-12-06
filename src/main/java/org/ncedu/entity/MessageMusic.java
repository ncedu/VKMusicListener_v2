package org.ncedu.entity;

/**
 * Created by nick on 02.12.16.
 */
public class MessageMusic {
    private String author;
    private String name;
    private String link;

    public MessageMusic() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "MessageMusic{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
