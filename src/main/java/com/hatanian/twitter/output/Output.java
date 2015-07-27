package com.hatanian.twitter.output;

import java.io.PrintStream;

public class Output {
    private PrintStream printStream;

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
