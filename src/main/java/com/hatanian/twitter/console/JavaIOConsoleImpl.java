package com.hatanian.twitter.console;

import java.io.IOException;

public class JavaIOConsoleImpl implements Console {
    private java.io.Console console = System.console();

    @Override
    public String readLine() throws IOException {
        return console.readLine();
    }
}
