package com.hatanian.twitter.command;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class UserInputProcessorTest {
    private UserInputProcessor userInputProcessor;
    private CommandFactory commandFactory;
    private Command command;

    @Before
    public void setUp() throws Exception {
        commandFactory = mock(CommandFactory.class);
        command = mock(Command.class);
        when(commandFactory.buildCommandFromUserInput(anyString())).thenReturn(command);
        userInputProcessor = new UserInputProcessor(commandFactory);
    }

    @Test
    public void shouldCallCommandFactoryWithUserInput() throws Exception {
        processUserInput();
        verify(commandFactory).buildCommandFromUserInput(eq("my input"));
    }

    @Test
    public void shouldRunCommandReturnedByCommandFactory() throws Exception {
        processUserInput();
        verify(command).run();
    }

    private void processUserInput() {
        userInputProcessor.processUserInput("my input");
    }
}