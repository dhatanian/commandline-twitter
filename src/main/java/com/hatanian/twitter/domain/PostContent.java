package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PostContent {
    private String content;

    public PostContent(String content) {
        this.content = content;
    }
}
