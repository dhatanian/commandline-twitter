package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Message;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class MessagesRepositoryTest extends TestUsingPersistence {

    @Test
    public void shouldReturnUserTimeline() throws Exception {
        Message messageToAlice = new Message("Alice", "Text", new Date());
        Message messageToBob = new Message("Bob", "Text2", new Date());
        MessagesRepository.getMessageList().add(messageToAlice);
        MessagesRepository.getMessageList().add(messageToBob);

        assertThat(MessagesRepository.getTimeline("Alice").toArray()).containsExactly(messageToAlice);
    }

    @Test
    public void shouldReturnUsersOwnMessagesInWall() {
        Message usersMessage = new Message("Charlie", "Text", new Date());
        MessagesRepository.getMessageList().add(usersMessage);

        assertThat(MessagesRepository.getWall("Charlie").toArray()).containsExactly(usersMessage);
    }

    @Test
    public void shouldReturnFollowedUsersMessagesInWall() {
        Message followedUsersMessage = new Message("Alice", "Text", new Date());
        MessagesRepository.getMessageList().add(followedUsersMessage);

        FolloweesRepository.addFollowee("Charlie", "Alice");

        assertThat(MessagesRepository.getWall("Charlie").toArray()).containsExactly(followedUsersMessage);
    }

    @Test
    public void shouldNotReturnNotFollowedUsersMessagesInWall() {
        Message followedUsersMessage = new Message("Alice", "Text", new Date());
        MessagesRepository.getMessageList().add(followedUsersMessage);

        assertThat(MessagesRepository.getWall("Charlie").toArray()).isEmpty();
    }

    @Test
    public void shouldReturnMessagesOrderedByDecrescentDateInWall() {
        long currentTime = System.currentTimeMillis();
        Message usersMessageCreatedFirst = new Message("Charlie", "Text1", new Date(currentTime - 3000L));
        Message followedUsersMessageCreatedSecond = new Message("Alice", "Text2", new Date(currentTime - 2000L));
        Message followedUsersMessageCreatedThird = new Message("Alice", "Text3", new Date(currentTime - 1000L));
        MessagesRepository.getMessageList().add(usersMessageCreatedFirst);
        MessagesRepository.getMessageList().add(followedUsersMessageCreatedSecond);
        MessagesRepository.getMessageList().add(followedUsersMessageCreatedThird);

        FolloweesRepository.addFollowee("Charlie", "Alice");
        assertThat(MessagesRepository.getWall("Charlie").toArray()).containsExactly(followedUsersMessageCreatedThird, followedUsersMessageCreatedSecond, usersMessageCreatedFirst);
    }
}