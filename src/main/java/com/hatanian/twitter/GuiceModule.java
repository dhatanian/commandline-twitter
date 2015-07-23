package com.hatanian.twitter;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.console.InputStreamConsoleImpl;
import com.hatanian.twitter.console.JavaIOConsoleImpl;
import com.hatanian.twitter.exit.ExitFlag;
import com.hatanian.twitter.exit.ProgramTerminator;
import com.hatanian.twitter.persistence.PostRepository;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    Console getConsole() {
        if (System.console() == null) {
            return new InputStreamConsoleImpl(System.in);
        } else {
            return new JavaIOConsoleImpl();
        }
    }
}
