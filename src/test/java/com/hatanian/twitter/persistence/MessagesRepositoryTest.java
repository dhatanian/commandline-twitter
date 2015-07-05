package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Message;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class MessagesRepositoryTest extends TestUsingPersistence {

    @Test
    public void testGetTimeline() throws Exception {
        Message messageToAlice = new Message("Alice", "Text", new Date());
        Message messageToBob = new Message("Bob", "Text2", new Date());
        MessagesRepository.getMessageList().add(messageToAlice);
        MessagesRepository.getMessageList().add(messageToBob);

        assertThat(MessagesRepository.getTimeline("Alice").toArray()).containsExactly(messageToAlice);
    }
}