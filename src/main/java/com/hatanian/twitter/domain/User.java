package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class User {
    private String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
