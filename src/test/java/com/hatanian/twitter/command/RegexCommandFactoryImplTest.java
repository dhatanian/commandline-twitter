package com.hatanian.twitter.command;

import com.hatanian.twitter.command.exit.ExitCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RegexCommandFactoryImplTest {

    @Test
    public void shouldReturnExitCommand() throws Exception {
        Command command = passCommand("exit");
        assertThat(command).isInstanceOf(ExitCommand.class);
    }

    private Command passCommand(String userInput) {
        return new RegexCommandFactoryImpl(mock(ExitCommand.class)).buildCommandFromUserInput(userInput);
    }


}