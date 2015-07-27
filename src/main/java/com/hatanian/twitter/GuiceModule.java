package com.hatanian.twitter;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

import java.io.PrintStream;
import java.time.Clock;

public class GuiceModule implements Module {
    @Override
    public void configure(Binder binder) {

    }

    @Provides
    public Clock getClock() {
        return Clock.systemDefaultZone();
    }

    @Provides
    public PrintStream getOutputPrintStream() {
        return System.out;
    }
}
