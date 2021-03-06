package com.hatanian.twitter.features;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.hatanian.twitter.ProgramTerminator;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.output.Output;

import java.time.Clock;

public class TestGuiceModule implements Module {

    private final Console console;
    private final Output out;
    private final ProgramTerminator programTerminator;
    private final ChangingClock clock;
    private final PostsRepository postsRepository;

    public TestGuiceModule(Console console, Output out, ProgramTerminator programTerminator, ChangingClock clock, PostsRepository postsRepository) {
        this.console = console;
        this.out = out;
        this.programTerminator = programTerminator;
        this.clock = clock;
        this.postsRepository = postsRepository;
    }

    @Override
    public void configure(Binder binder) {

    }

    @Provides
    public Output getOuput() {
        return out;
    }

    @Provides
    public Console getConsole() {
        return console;
    }

    @Provides
    public ProgramTerminator getProgramTerminator() {
        return programTerminator;
    }

    @Provides
    public Clock getClock() {
        return clock;
    }

    @Provides
    public PostsRepository getPostsRepository() {
        return postsRepository;
    }
}
