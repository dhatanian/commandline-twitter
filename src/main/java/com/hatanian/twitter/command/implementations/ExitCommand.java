package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.App;
import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Message;
import com.hatanian.twitter.persistence.MessagesRepository;

import java.io.PrintStream;
import java.util.Date;

public class ExitCommand extends Command {

    public ExitCommand() {
        super(null);
    }

    @Override
    public void run(PrintStream outputStream) {
        App.exit();
    }
}
