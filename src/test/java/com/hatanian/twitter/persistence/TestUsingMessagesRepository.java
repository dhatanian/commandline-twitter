package com.hatanian.twitter.persistence;

import org.junit.After;

/**
 * This class is just here to flush the message repository between tests
 */
public abstract class TestUsingMessagesRepository {
    @After
    public void flushMessages() {
        MessagesRepository.getMessageList().clear();
    }
}
