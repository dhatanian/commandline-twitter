package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PostContent {
    private String value;

    public PostContent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
