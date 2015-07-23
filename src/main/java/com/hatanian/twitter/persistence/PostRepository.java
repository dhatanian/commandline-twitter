package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Post;

import java.util.LinkedList;
import java.util.List;

public class PostRepository {
    protected static List<Post> postList = new LinkedList<>();

    public void save(Post post) {
        postList.add(post);
    }
}
