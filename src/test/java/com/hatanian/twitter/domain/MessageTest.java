package com.hatanian.twitter.domain;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

    @Test
    public void shouldDisplayMomentsAgoForMessagesYoungerThanOneSecond() throws Exception {
        Message message = new Message("", "", new Date(System.currentTimeMillis() - 500L));
        assertThat(message.asString()).isEqualTo(" (moments ago)");
    }

    @Test
    public void shouldDisplayNumberOfSecondsAgoForMessagesOlderThanOneSecondButYoungerThanOneMinute() throws Exception {
        Message message = new Message("", "", new Date(System.currentTimeMillis() - 3000L));
        assertThat(message.asString()).isEqualTo(" (3 seconds ago)");
    }

    @Test
    public void shouldDisplayNumberOfMinutesAgoForMessagesOlderThanOneMinuteButYoungerThanOneHour() throws Exception {
        Message message = new Message("", "", new Date(System.currentTimeMillis() - 60 * 4000L));
        assertThat(message.asString()).isEqualTo(" (4 minutes ago)");
    }


}