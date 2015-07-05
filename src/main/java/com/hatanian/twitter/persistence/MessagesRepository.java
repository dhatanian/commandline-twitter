package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Message;

import java.util.LinkedList;
import java.util.List;

/**
 * This class holds all the messages in a static List.
 * Given that we're running only one thread, we do not have to worry about multithreadism and whether to synchronize accesses to the List.
 */
public abstract class MessagesRepository {
    private static List<Message> messageList = new LinkedList<>();

    public static List<Message> getMessageList() {
        return messageList;
    }
}
