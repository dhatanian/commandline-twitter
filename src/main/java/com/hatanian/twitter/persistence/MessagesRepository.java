package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Message;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class holds all the messages in a static List.
 * Given that we're running only one thread, we do not have to worry about multithreadism and whether to synchronize accesses to the List.
 */
public abstract class MessagesRepository {
    private static List<Message> messageList = new LinkedList<>();

    public static List<Message> getMessageList() {
        return messageList;
    }

    public static Stream<Message> getTimeline(String user) {
        return messageList.stream().filter(message -> message.getAuthor().equals(user));
    }

    public static Stream<Message> getWall(String user) {
        return Stream.concat(Stream.of(user), FolloweesRepository.getFollowees(user).stream()).flatMap(MessagesRepository::getTimeline).sorted(Comparator.comparing(Message::getCreationDate).reversed());
    }
}
