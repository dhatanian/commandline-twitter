package com.hatanian.twitter;

import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.output.Output;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    boolean exitFlagRaised;

    @Mock
    Console mockConsole;

    @Mock
    UserInputProcessor mockUserInputProcessor;

    @Mock
    Output mockOutput;

    @Mock
    ExitFlag mockExitFlag;

    @Mock
    ProgramTerminator mockProgramTerminator;


    @Before
    public void setUp() throws Exception {
        exitFlagRaised = false;
        when(mockExitFlag.isRaised()).then(invocation -> {
            boolean result = exitFlagRaised;
            //We raise the exist flag after the first call
            exitFlagRaised = true;
            return result;
        });
    }

    @Test
    public void shouldPassUserInputToUserInputProcessor() throws IOException {
        when(mockConsole.readLine()).thenReturn("my input");
        runApp();
        verify(mockUserInputProcessor).processUserInput(eq("my input"));
    }

    @Test
    public void shouldCallProgramTerminatorToExitWhenExitFlagIsRaised() throws IOException {
        runApp();
        InOrder inOrder = inOrder(mockExitFlag, mockProgramTerminator);
        inOrder.verify(mockExitFlag, times(2)).isRaised();
        inOrder.verify(mockProgramTerminator).terminateProgram();
    }

    @Test
    public void shouldDisplayHelpMessagesToTheUser() throws Exception {
        runApp();
        InOrder inOrder = inOrder(mockOutput);
        inOrder.verify(mockOutput).println("Welcome on this Command Line social network !");
        inOrder.verify(mockOutput).print("> ");
        inOrder.verify(mockOutput).println("Thank you, good bye !");
    }

    private void runApp() throws IOException {
        new App(mockExitFlag, mockOutput, mockProgramTerminator, mockUserInputProcessor, mockConsole).run();
    }

}