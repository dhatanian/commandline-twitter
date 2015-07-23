package com.hatanian.twitter.command.exit;

import com.google.inject.Inject;
import com.hatanian.twitter.exit.ExitFlag;

public class ExitCommandFactory {
    private ExitFlag exitFlag;

    @Inject
    public ExitCommandFactory(ExitFlag exitFlag) {
        this.exitFlag = exitFlag;
    }

    public ExitCommand buildExitCommand() {
        return new ExitCommand(exitFlag);
    }
}
