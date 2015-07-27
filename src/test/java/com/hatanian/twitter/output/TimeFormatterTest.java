package com.hatanian.twitter.output;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeFormatterTest {
    TimeFormatter timeFormatter = new TimeFormatter(Clock.fixed(Instant.ofEpochMilli(REFERENCE_TIME), ZoneId.of("UTC")));
    private static final long REFERENCE_TIME = 1437776421000L;

    public TimeFormatterTest() {
        TimeFormatter.PRETTY_TIME.setReference(new Date(REFERENCE_TIME));
    }

    @Test
    public void shouldDisplayMomentsAgoForMessagesYoungerThanOneSecond() throws Exception {
        assertThat(formatDateWithAgeInMS(500L)).isEqualTo("moments ago");
    }

    @Test
    public void shouldDisplayNumberOfSecondsAgoForMessagesOlderThanOneSecondButYoungerThanOneMinute() throws Exception {
        assertThat(formatDateWithAgeInMS(3000L)).isEqualTo("3 seconds ago");
    }

    @Test
    public void shouldDisplayNumberOfMinutesAgoForMessagesOlderThanOneMinuteButYoungerThanOneHour() throws Exception {
        assertThat(formatDateWithAgeInMS(60 * 4000L)).isEqualTo("4 minutes ago");
    }

    String formatDateWithAgeInMS(long ageInMS) {
        return timeFormatter.formatDateAsTimePastSince(new Date(REFERENCE_TIME - ageInMS));
    }

}
