package com.hatanian.twitter.command;

import com.hatanian.twitter.command.exit.ExitCommand;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.post.PostCommand;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommand;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommandFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {
    @Mock
    ExitCommandFactory mockExitCommandFactory;

    @Mock
    ExitCommand mockExitCommand;

    @Mock
    PostCommandFactory mockPostCommandFactory;

    @Mock
    PostCommand mockPostCommand;

    @Mock
    ViewTimelineCommandFactory mockViewTimelineCommandFactory;

    @Mock
    ViewTimelineCommand mockViewTimelineCommand;


    @Test
    public void shouldReturnExitCommand() throws Exception {
        when(mockExitCommandFactory.createExitCommand()).thenReturn(mockExitCommand);
        Command command = passCommand("exit");
        assertThat(command).isEqualTo(mockExitCommand);
    }

    @Test
    public void shouldReturnPostCommand() throws Exception {
        when(mockPostCommandFactory.createPostCommand(anyString(), anyString())).thenReturn(mockPostCommand);
        Command command = passCommand("Alice -> My message");
        verify(mockPostCommandFactory).createPostCommand(eq("Alice"), eq("My message"));
        assertThat(command).isEqualTo(mockPostCommand);
    }

    @Test
    public void shouldReturnViewTimelineCommmand() throws Exception {
        when(mockViewTimelineCommandFactory.createViewTimelineCommand(anyString())).thenReturn(mockViewTimelineCommand);
        Command command = passCommand("Alice");
        verify(mockViewTimelineCommandFactory).createViewTimelineCommand(eq("Alice"));
        assertThat(command).isEqualTo(mockViewTimelineCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenUserInputIsNotParseable() throws Exception {
        passCommand("a b");
    }

    private Command passCommand(String userInput) {
        return new CommandFactory(mockExitCommandFactory, mockPostCommandFactory, mockViewTimelineCommandFactory).createCommand(userInput);
    }
}