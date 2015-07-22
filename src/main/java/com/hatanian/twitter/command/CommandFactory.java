package com.hatanian.twitter.command;

public interface CommandFactory {
    public Command buildCommandFromUserInput(String userInput);
}
