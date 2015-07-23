package com.hatanian.twitter.command;

import com.google.inject.Inject;

public class UserInputProcessor {
    private CommandFactory commandFactory;

    @Inject
    public UserInputProcessor(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void processUserInput(String userInput) {
        commandFactory.buildCommandFromUserInput(userInput).run();
    }
}
