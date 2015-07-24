package com.hatanian.twitter;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.console.InputStreamConsoleImpl;
import com.hatanian.twitter.console.JavaIOConsoleImpl;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.output.TimeFormatter;

import java.time.Clock;

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

    @Provides
    Output getOutput() {
        return new Output(System.out, new PostFormatter(new TimeFormatter()));
    }

    @Provides
    Clock getClock() {
        return Clock.systemDefaultZone();
    }
}
