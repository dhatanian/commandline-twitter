package com.hatanian.twitter.command;

import com.google.inject.Inject;

public class CommandUserInputProcessorImpl implements UserInputProcessor {
    private CommandFactory commandFactory;

    @Inject
    public CommandUserInputProcessorImpl(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void processUserInput(String userInput) {
        commandFactory.buildCommandFromUserInput(userInput).run();
    }
}
