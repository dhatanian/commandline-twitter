package com.hatanian.twitter.exit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExitFlagImplTest {
    ExitFlag exitFlag = new ExitFlagImpl();

    @Test
    public void shouldNotBeRaisedFirst() throws Exception {
        assertFalse(exitFlag.isRaised());
    }

    @Test
    public void shouldBeRaisedAfterCallingRaiseMethod() throws Exception {
        exitFlag.raise();
        assertTrue(exitFlag.isRaised());

    }
}