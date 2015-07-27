package com.hatanian.twitter.command;

import com.google.inject.Inject;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.follows.FollowsCommandFactory;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommandFactory;
import com.hatanian.twitter.command.wall.WallCommandFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private ExitCommandFactory exitCommandFactory;
    private PostCommandFactory postCommandFactory;
    private ViewTimelineCommandFactory viewTimelineCommandFactory;
    private FollowsCommandFactory followsCommandFactory;
    private WallCommandFactory wallCommandFactory;

    private static final Pattern EXIT_REGEX = Pattern.compile("^exit$");
    private static final Pattern POST_REGEX = Pattern.compile("^(\\w+) -> (.*)$");
    private static final Pattern VIEW_TIMELINE_REGEX = Pattern.compile("^(\\w+)$");
    private static final Pattern FOLLOWS_REGEX = Pattern.compile("^(\\w+) follows (\\w+)$");
    private static final Pattern WALL_REGEX = Pattern.compile("^(\\w+) wall$");

    @Inject
    public CommandFactory(ExitCommandFactory exitCommandFactory, PostCommandFactory postCommandFactory, ViewTimelineCommandFactory viewTimelineCommandFactory, FollowsCommandFactory followsCommandFactory, WallCommandFactory wallCommandFactory) {
        this.exitCommandFactory = exitCommandFactory;
        this.postCommandFactory = postCommandFactory;
        this.viewTimelineCommandFactory = viewTimelineCommandFactory;
        this.followsCommandFactory = followsCommandFactory;
        this.wallCommandFactory = wallCommandFactory;
    }

    public Command createCommand(String userInput) {
        if (EXIT_REGEX.matcher(userInput).matches()) {
            return exitCommandFactory.createExitCommand();
        }

        Matcher postMatcher = POST_REGEX.matcher(userInput);
        if (postMatcher.matches()) {
            return postCommandFactory.createPostCommand(postMatcher.group(1), postMatcher.group(2));
        }

        Matcher viewTimelineMatcher = VIEW_TIMELINE_REGEX.matcher(userInput);
        if (viewTimelineMatcher.matches()) {
            return viewTimelineCommandFactory.createViewTimelineCommand(viewTimelineMatcher.group(1));
        }

        Matcher followsMatcher = FOLLOWS_REGEX.matcher(userInput);
        if (followsMatcher.matches()) {
            return followsCommandFactory.createFollowsCommand(followsMatcher.group(1), followsMatcher.group(2));
        }

        Matcher wallMatcher = WALL_REGEX.matcher(userInput);
        if (wallMatcher.matches()) {
            return wallCommandFactory.createWallCommand(wallMatcher.group(1));
        }

        throw new IllegalArgumentException("Unknown command : " + userInput);
    }
}
