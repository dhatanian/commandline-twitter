package com.hatanian.twitter.domain;

import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class Post {
    private final User author;
    private final PostContent content;
    private Date creationDate;

    public Post(User author, PostContent content) {
        this.author = author;
        this.content = content;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public PostContent getContent() {
        return content;
    }
}
