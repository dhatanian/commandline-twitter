package com.hatanian.twitter.command;

import com.google.inject.Inject;
import com.hatanian.twitter.command.exit.ExitCommand;

public class RegexCommandFactoryImpl implements CommandFactory {
    private ExitCommand exitCommand;

    @Inject
    public RegexCommandFactoryImpl(ExitCommand exitCommand) {
        this.exitCommand = exitCommand;
    }

    @Override
    public Command buildCommandFromUserInput(String userInput) {
        return exitCommand;
    }
}
