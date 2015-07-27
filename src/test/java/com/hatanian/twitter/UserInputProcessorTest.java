package com.hatanian.twitter;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.command.CommandFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserInputProcessorTest {
    @Mock
    CommandFactory mockCommandFactory;

    @Mock
    Command mockCommand;

    UserInputProcessor userInputProcessor;

    @Before
    public void setUp() throws Exception {
        userInputProcessor = new UserInputProcessor(mockCommandFactory);
        when(mockCommandFactory.createCommand(anyString())).thenReturn(mockCommand);
    }

    @Test
    public void shouldPassUserCommandToFactory() throws Exception {
        userInputProcessor.processUserInput("input");
        verify(mockCommandFactory).createCommand(eq("input"));
    }

    @Test
    public void shouldCallCommandReturnedByFactory() throws Exception {
        userInputProcessor.processUserInput("input");
        verify(mockCommand).run();
    }
}