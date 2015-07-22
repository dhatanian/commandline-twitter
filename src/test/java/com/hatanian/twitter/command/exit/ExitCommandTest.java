package com.hatanian.twitter.command.exit;

import com.hatanian.twitter.exit.ExitFlag;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExitCommandTest {

    @Test
    public void shouldRaiseExitFlag() throws Exception {
        ExitFlag mockExitFlag = mock(ExitFlag.class);
        new ExitCommand(mockExitFlag).run();
        verify(mockExitFlag).raise();
    }
}