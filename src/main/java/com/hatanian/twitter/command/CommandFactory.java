package com.hatanian.twitter.command;

import com.google.inject.Inject;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private ExitCommandFactory exitCommandFactory;
    private PostCommandFactory postCommandFactory;

    private final Pattern EXIT_REGEX = Pattern.compile("^exit$");
    private final Pattern POST_REGEX = Pattern.compile("^(\\w+) -> (\\w+)$");

    @Inject
    public CommandFactory(ExitCommandFactory exitCommandFactory, PostCommandFactory postCommandFactory) {
        this.exitCommandFactory = exitCommandFactory;
        this.postCommandFactory = postCommandFactory;
    }

    public Command buildCommandFromUserInput(String userInput) {
        if (EXIT_REGEX.matcher(userInput).matches()) {
            return exitCommandFactory.buildExitCommand();
        }

        Matcher postMatcher = POST_REGEX.matcher(userInput);
        if (postMatcher.matches()) {
            return postCommandFactory.buildPostCommand(new User(postMatcher.group(1)), new PostContent(postMatcher.group(2)));
        }

        //We throw an unchecked exception since we don't expect the caller to handle it (we do not want to deal with wrong inputs in this exercise)
        throw new IllegalArgumentException("Unable to parse input : " + userInput);
    }
}
