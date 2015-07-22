package com.hatanian.twitter;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hatanian.twitter.app.App;
import com.hatanian.twitter.app.AppImpl;
import com.hatanian.twitter.command.CommandFactory;
import com.hatanian.twitter.command.CommandUserInputProcessorImpl;
import com.hatanian.twitter.command.RegexCommandFactoryImpl;
import com.hatanian.twitter.command.UserInputProcessor;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.console.InputStreamConsoleImpl;
import com.hatanian.twitter.console.JavaIOConsoleImpl;
import com.hatanian.twitter.exit.ExitFlag;
import com.hatanian.twitter.exit.ExitFlagImpl;
import com.hatanian.twitter.exit.ProgramTerminator;
import com.hatanian.twitter.exit.SystemExitProgramTerminatorImpl;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(App.class).to(AppImpl.class);
        bind(CommandFactory.class).to(RegexCommandFactoryImpl.class);
        bind(UserInputProcessor.class).to(CommandUserInputProcessorImpl.class);
        bind(ExitFlag.class).to(ExitFlagImpl.class);
        bind(ProgramTerminator.class).to(SystemExitProgramTerminatorImpl.class);
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
