package com.hatanian.twitter;

import com.google.inject.Inject;
import com.hatanian.twitter.command.CommandFactory;

public class UserInputProcessor {
    private CommandFactory commandFactory;

    @Inject
    public UserInputProcessor(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void processUserInput(String userInput) {
        commandFactory.createCommand(userInput).run();
    }
}
