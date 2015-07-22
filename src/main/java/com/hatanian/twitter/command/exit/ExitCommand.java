package com.hatanian.twitter.command.exit;

import com.google.inject.Inject;
import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.exit.ExitFlag;

public class ExitCommand implements Command {
    private ExitFlag exitFlag;

    @Inject
    public ExitCommand(ExitFlag exitFlag) {
        this.exitFlag = exitFlag;
    }

    @Override
    public void run() {
        exitFlag.raise();
    }
}
