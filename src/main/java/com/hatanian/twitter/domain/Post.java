package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class Post {
    private User user;
    private PostContent content;
    private Date creationDate;

    public Post(User user, PostContent content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PostContent getContent() {
        return content;
    }
}
