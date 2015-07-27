package com.hatanian.twitter;

import com.google.inject.Inject;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.output.Output;

import java.io.IOException;


public class App {
    private ExitFlag exitFlag;
    private Output output;
    private ProgramTerminator programTerminator;
    private UserInputProcessor userInputProcessor;
    private Console console;

    @Inject
    public App(ExitFlag exitFlag, Output output, ProgramTerminator programTerminator, UserInputProcessor userInputProcessor, Console console) {
        this.exitFlag = exitFlag;
        this.output = output;
        this.programTerminator = programTerminator;
        this.userInputProcessor = userInputProcessor;
        this.console = console;
    }

    public void run() throws IOException {
        output.println("Welcome on this Command Line social network !");

        while (!exitFlag.isRaised()) {
            output.print("> ");
            userInputProcessor.processUserInput(console.readLine());
        }
        output.println("Thank you, good bye !");
        programTerminator.terminateProgram();
    }
}
