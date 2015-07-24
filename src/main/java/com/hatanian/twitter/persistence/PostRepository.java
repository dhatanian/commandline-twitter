package com.hatanian.twitter.persistence;

import com.google.inject.Inject;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;

import java.time.Clock;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class PostRepository {
    static List<Post> postList = new LinkedList<>();
    private Clock clock;

    @Inject
    public PostRepository(Clock clock) {
        this.clock = clock;
    }

    public void save(Post post) {
        post.setCreationDate(new Date(clock.millis()));
        postList.add(post);
    }

    public Stream<Post> getUserTimeline(User user) {
        return postList.stream().filter(post -> post.getUser().equals(user)).sorted(Comparator.comparing(Post::getCreationDate).reversed());
    }
}
