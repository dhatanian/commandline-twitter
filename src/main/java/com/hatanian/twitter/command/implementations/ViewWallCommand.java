package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.persistence.MessagesRepository;

import java.io.PrintStream;

public class ViewWallCommand extends Command {
    public ViewWallCommand(String user) {
        super(user);
    }

    @Override
    public void run(PrintStream outputStream) {
        MessagesRepository.getWall(getUser()).forEachOrdered(message -> outputStream.println(message.asString(true)));
    }
}
