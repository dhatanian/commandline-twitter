package com.hatanian.twitter.command.exit;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.exit.ExitFlag;

public class ExitCommand implements Command {
    private ExitFlag exitFlag;

    protected ExitCommand(ExitFlag exitFlag) {
        this.exitFlag = exitFlag;
    }

    @Override
    public void run() {
        exitFlag.raise();
    }
}
