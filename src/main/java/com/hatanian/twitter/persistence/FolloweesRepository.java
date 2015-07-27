package com.hatanian.twitter.persistence;

import com.google.inject.Singleton;
import com.hatanian.twitter.domain.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Singleton
public class FolloweesRepository {
    Map<User, Set<User>> followees = new HashMap<>();

    public void saveFollowee(User follower, User followee) {
        Set<User> thoseFollowees = getFollowees(follower);
        thoseFollowees.add(followee);
    }

    public Set<User> getFollowees(User follower) {
        Set<User> thoseFollowees = followees.get(follower);
        if (thoseFollowees == null) {
            thoseFollowees = new HashSet<>();
            followees.put(follower, thoseFollowees);
        }
        return thoseFollowees;
    }
}
