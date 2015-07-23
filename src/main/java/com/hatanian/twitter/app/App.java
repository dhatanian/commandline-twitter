package com.hatanian.twitter.app;

import com.google.inject.Inject;
import com.hatanian.twitter.command.UserInputProcessor;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.exit.ExitFlag;
import com.hatanian.twitter.exit.ProgramTerminator;

import java.io.IOException;

public class App {
    private final ExitFlag exitFlag;
    private final Console console;
    private ProgramTerminator programTerminator;
    private UserInputProcessor userInputProcessor;

    @Inject
    public App(ExitFlag exitFlag, Console console, ProgramTerminator programTerminator, UserInputProcessor userInputProcessor) {
        this.exitFlag = exitFlag;
        this.console = console;
        this.programTerminator = programTerminator;
        this.userInputProcessor = userInputProcessor;
    }

    public void run() throws IOException {
        System.out.println("Welcome on this Command Line social network !");

        while (!exitFlag.isRaised()) {
            System.out.print("> ");
            userInputProcessor.processUserInput(console.readLine());
        }
        System.out.println("Thank you, good bye !");
        programTerminator.terminateProgram();
    }
}
