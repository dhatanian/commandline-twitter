package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Message;
import com.hatanian.twitter.persistence.MessagesRepository;

import java.io.PrintStream;
import java.util.Date;

public class PostingCommand extends Command {
    private String message;
    private Date postDate;

    public PostingCommand(String user, String message, Date postDate) {
        super(user);
        this.message = message;
        this.postDate = postDate;
    }

    public String getMessage() {
        return message;
    }

    public Date getPostDate() {
        return postDate;
    }

    @Override
    public void run(PrintStream outputStream) {
        MessagesRepository.getMessageList().add(new Message(getUser(), getMessage(), getPostDate()));
    }
}
