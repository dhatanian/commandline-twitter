package com.hatanian.twitter.command.follows;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.domain.User;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class FollowsCommand implements Command {
    private FolloweesRepository followeesRepository;
    private final User follower;
    private final User followee;

    public FollowsCommand(FolloweesRepository followeesRepository, User follower, User followee) {
        this.followeesRepository = followeesRepository;
        this.follower = follower;
        this.followee = followee;
    }

    @Override
    public void run() {
        followeesRepository.saveFollowee(follower, followee);
    }
}
