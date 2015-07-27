package com.hatanian.twitter.command;

import com.hatanian.twitter.ExitFlag;
import com.hatanian.twitter.command.exit.ExitCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExitCommandTest {
    @Mock
    ExitFlag mockExitFlag;

    @Test
    public void shouldRaiseExitFlag() throws Exception {
        new ExitCommand(mockExitFlag).run();
        verify(mockExitFlag).raise();
    }
}