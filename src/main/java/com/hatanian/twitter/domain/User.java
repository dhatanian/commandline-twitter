package com.hatanian.twitter.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
