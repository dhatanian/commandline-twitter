package com.hatanian.twitter.features;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ChangingClock extends Clock {
    private ZoneId zoneId = ZoneId.of("UTC");
    private long currentTime;

    public ChangingClock(long currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public ZoneId getZone() {
        return zoneId;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return this;
    }

    @Override
    public Instant instant() {
        return Instant.ofEpochMilli(currentTime);
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
}
