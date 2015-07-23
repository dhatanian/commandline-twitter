package com.hatanian.twitter.app;

import com.hatanian.twitter.command.UserInputProcessor;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.exit.ExitFlag;
import com.hatanian.twitter.exit.ProgramTerminator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class AppTest {
    ExitFlag mockExitFlag;
    Console mockConsole;
    ProgramTerminator mockProgramTerminator;
    UserInputProcessor userInputProcessor;
    boolean exitFlagRaised = false;

    @Before
    public void setup() {
        exitFlagRaised = false;
        mockExitFlag = mock(ExitFlag.class);
        when(mockExitFlag.isRaised()).then(invocation -> {
            boolean result = exitFlagRaised;
            //We raise the exist flag after the first call
            exitFlagRaised = true;
            return result;
        });
        mockConsole = mock(Console.class);
        mockProgramTerminator = mock(ProgramTerminator.class);
        userInputProcessor = mock(UserInputProcessor.class);
    }

    @Test
    public void shouldPassUserInputToUserInputProcessor() throws IOException {
        when(mockConsole.readLine()).thenReturn("my input");
        runApp();
        verify(userInputProcessor).processUserInput(eq("my input"));
    }

    @Test
    public void shouldReadLineFromConsole() throws IOException {
        runApp();
        verify(mockConsole).readLine();
    }

    @Test
    public void shouldCallProgramTerminator() throws IOException {
        runApp();
        verify(mockProgramTerminator).terminateProgram();
    }

    @Test
    public void shouldStopWhenExitFlagIsRaised() throws IOException {
        runApp();
        verify(mockExitFlag, times(2)).isRaised();
    }

    private void runApp() throws IOException {
        new App(mockExitFlag, mockConsole, mockProgramTerminator, userInputProcessor).run();
    }

}