package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.persistence.FolloweesRepository;

import java.io.PrintStream;

public class FollowCommand extends Command {
    private String followedUser;

    public FollowCommand(String user, String followedUser) {
        super(user);
        this.followedUser = followedUser;
    }

    @Override
    public void run(PrintStream outputStream) {
        FolloweesRepository.addFollowee(getUser(), getFollowedUser());
    }

    public String getFollowedUser() {
        return followedUser;
    }
}
