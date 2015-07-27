package com.hatanian.twitter.command.wall;

import com.google.inject.Inject;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.output.PostFormatter;

public class WallCommandFactory {
    private final WallService wallService;
    private final Output output;
    private final PostFormatter postFormatter;

    @Inject
    public WallCommandFactory(WallService wallService, Output output, PostFormatter postFormatter) {
        this.wallService = wallService;
        this.output = output;
        this.postFormatter = postFormatter;
    }

    public WallCommand createWallCommand(String user) {
        return new WallCommand(wallService, output, postFormatter, new User(user));
    }
}
