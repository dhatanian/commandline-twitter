package com.hatanian.twitter.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class holds all the users followed by a given user in a static Map.
 * Given that we're running only one thread, we do not have to worry about multithreadism and whether to synchronize accesses to the Map.
 */
public abstract class FolloweesRepository {
    private static Map<String, Set<String>> followees = new HashMap<>();

    public static Map<String, Set<String>> getFollowees() {
        return followees;
    }

    public static void addFollowee(String user, String followee) {
        Set<String> thisUserFollowees = getFollowees(user);
        thisUserFollowees.add(followee);
    }

    public static Set<String> getFollowees(String user) {
        Set<String> thisUserFollowees = followees.get(user);
        if (thisUserFollowees == null) {
            thisUserFollowees = new HashSet<>();
            followees.put(user, thisUserFollowees);
        }
        return thisUserFollowees;
    }

}
