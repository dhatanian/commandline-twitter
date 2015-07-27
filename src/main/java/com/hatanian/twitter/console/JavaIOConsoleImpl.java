package com.hatanian.twitter.console;

public class JavaIOConsoleImpl implements Console {

    @Override
    public String readLine() {
        return System.console().readLine();
    }
}
