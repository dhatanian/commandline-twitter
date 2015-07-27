package com.hatanian.twitter.command.wall;

import com.google.inject.Inject;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.persistence.PostsRepository;

import java.util.Comparator;
import java.util.stream.Stream;

public class WallService {
    private FolloweesRepository followeesRepository;
    private PostsRepository postsRepository;

    @Inject
    public WallService(FolloweesRepository followeesRepository, PostsRepository postsRepository) {
        this.followeesRepository = followeesRepository;
        this.postsRepository = postsRepository;
    }

    public Stream<Post> getUserWall(User user) {
        return Stream.concat(Stream.of(user), followeesRepository.getFollowees(user).stream()).flatMap(postsRepository::getUserTimeline).sorted(Comparator.comparing(Post::getCreationDate).reversed());
    }
}
