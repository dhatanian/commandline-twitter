package com.hatanian.twitter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ExitFlagTest {
    @Test
    public void shouldShowFlagIsRaisedOnlyAfterRequestedToRaiseIt() throws Exception {
        ExitFlag exitFlag = new ExitFlag();
        assertThat(exitFlag.isRaised()).isFalse();
        exitFlag.raise();
        assertThat(exitFlag.isRaised()).isTrue();
    }
}