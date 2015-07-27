package com.hatanian.twitter.command.exit;

import com.google.inject.Inject;
import com.hatanian.twitter.ExitFlag;

public class ExitCommandFactory {
    private ExitFlag exitFlag;

    @Inject
    public ExitCommandFactory(ExitFlag exitFlag) {
        this.exitFlag = exitFlag;
    }

    public ExitCommand createExitCommand() {
        return new ExitCommand(exitFlag);
    }
}
