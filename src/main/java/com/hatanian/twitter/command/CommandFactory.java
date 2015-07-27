package com.hatanian.twitter.command;

import com.google.inject.Inject;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommandFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private ExitCommandFactory exitCommandFactory;
    private PostCommandFactory postCommandFactory;
    private ViewTimelineCommandFactory viewTimelineCommandFactory;

    private static final Pattern EXIT_REGEX = Pattern.compile("^exit$");
    private static final Pattern POST_REGEX = Pattern.compile("^(\\w+) -> (.*)$");
    private static final Pattern VIEW_TIMELINE_REGEX = Pattern.compile("^(\\w+)$");


    @Inject
    public CommandFactory(ExitCommandFactory exitCommandFactory, PostCommandFactory postCommandFactory, ViewTimelineCommandFactory viewTimelineCommandFactory) {
        this.exitCommandFactory = exitCommandFactory;
        this.postCommandFactory = postCommandFactory;
        this.viewTimelineCommandFactory = viewTimelineCommandFactory;
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


        throw new IllegalArgumentException("Unknown command : " + userInput);
    }
}
