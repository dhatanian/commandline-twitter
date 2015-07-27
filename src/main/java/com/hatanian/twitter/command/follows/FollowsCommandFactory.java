package com.hatanian.twitter.command.follows;

import com.google.inject.Inject;
import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.domain.User;

public class FollowsCommandFactory {
    private FolloweesRepository followeesRepository;

    @Inject
    public FollowsCommandFactory(FolloweesRepository followeesRepository) {
        this.followeesRepository = followeesRepository;
    }

    public FollowsCommand createFollowsCommand(String follower, String followee) {
        return new FollowsCommand(followeesRepository, new User(follower), new User(followee));
    }
}
