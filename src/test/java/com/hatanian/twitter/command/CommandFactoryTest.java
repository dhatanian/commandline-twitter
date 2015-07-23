package com.hatanian.twitter.command;

import com.hatanian.twitter.command.exit.ExitCommand;
import com.hatanian.twitter.command.post.PostCommand;
import com.hatanian.twitter.command.post.PostCommandFactory;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandFactoryTest {
    private PostCommandFactory mockPostCommandFactory;

    @Before
    public void setUp() throws Exception {
        mockPostCommandFactory = mock(PostCommandFactory.class);
    }

    @Test
    public void shouldReturnExitCommand() throws Exception {
        Command command = passCommand("exit");
        assertThat(command).isInstanceOf(ExitCommand.class);
    }

    @Test
    public void shouldReturnPostCommand() throws Exception {
        PostCommand mockPostCommand = mock(PostCommand.class);
        when(mockPostCommandFactory.buildPostCommand(any(), any())).thenReturn(mockPostCommand);
        Command command = passCommand("Alice -> Post");
        assertThat(command).isEqualTo(mockPostCommand);
    }

    private Command passCommand(String userInput) {
        return new CommandFactory(mock(ExitCommand.class), mockPostCommandFactory).buildCommandFromUserInput(userInput);
    }


}