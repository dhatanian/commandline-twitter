package com.hatanian.twitter.output;

import com.google.inject.Inject;

import java.io.PrintStream;

public class Output {
    private PrintStream printStream;

    @Inject
    public Output(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void println(String line) {
        printStream.println(line);
    }

    public void print(String text) {
        printStream.print(text);
    }
}
