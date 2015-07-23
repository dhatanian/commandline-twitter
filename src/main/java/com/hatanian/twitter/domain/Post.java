package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Post {
    private User user;
    private PostContent content;

    public Post(User user, PostContent content) {
        this.user = user;
        this.content = content;
    }
}
