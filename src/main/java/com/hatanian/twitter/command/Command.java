package com.hatanian.twitter.command;

import java.io.PrintStream;

public abstract class Command {
    private String user;

    public Command(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public abstract void run(PrintStream outputStream);
}
