package com.hatanian.twitter.command.persistence;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;

import java.time.Clock;
import java.util.*;
import java.util.stream.Stream;

@Singleton
public class PostRepository {
    List<Post> postList = new LinkedList<>();
    private Clock clock;

    @Inject
    public PostRepository(Clock clock) {
        this.clock = clock;
    }

    public void savePost(Post post) {
        post.setCreationDate(new Date(clock.millis()));
        postList.add(post);
    }

    public Stream<Post> getUserTimeline(User user) {
        return postList.stream().filter(post -> post.getAuthor().equals(user)).sorted(Comparator.comparing(Post::getCreationDate).reversed());
    }
}
