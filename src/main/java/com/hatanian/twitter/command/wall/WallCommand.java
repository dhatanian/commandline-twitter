package com.hatanian.twitter.command.wall;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.output.PostFormatter;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WallCommand implements Command {
    private final WallService wallService;
    private final Output output;
    private final PostFormatter postFormatter;
    private final User user;

    public WallCommand(WallService wallService, Output output, PostFormatter postFormatter, User user) {
        this.wallService = wallService;
        this.output = output;
        this.postFormatter = postFormatter;
        this.user = user;
    }

    @Override
    public void run() {
        wallService.getUserWall(user).map(postFormatter::formatForWall).forEachOrdered(output::println);
    }
}
