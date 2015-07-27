package com.hatanian.twitter.command.exit;

import com.hatanian.twitter.ExitFlag;
import com.hatanian.twitter.command.Command;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ExitCommand implements Command {
    private ExitFlag exitFlag;

    public ExitCommand(ExitFlag exitFlag) {
        this.exitFlag = exitFlag;
    }

    @Override
    public void run() {
        exitFlag.raise();
    }
}
