package com.hatanian.twitter.command;

import com.hatanian.twitter.command.exit.ExitCommand;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.follows.FollowsCommand;
import com.hatanian.twitter.command.follows.FollowsCommandFactory;
import com.hatanian.twitter.command.post.PostCommand;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommand;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommandFactory;
import com.hatanian.twitter.command.wall.WallCommand;
import com.hatanian.twitter.command.wall.WallCommandFactory;
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

    @Mock
    FollowsCommandFactory mockFollowsCommandFactory;

    @Mock
    FollowsCommand mockFollowsCommand;

    @Mock
    private WallCommandFactory mockWallCommandFactory;

    @Mock
    private WallCommand mockWallCommand;


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

    @Test
    public void shouldReturnFollowsCommand() throws Exception {
        when(mockFollowsCommandFactory.createFollowsCommand(anyString(), anyString())).thenReturn(mockFollowsCommand);
        Command command = passCommand("Charlie follows Alice");
        verify(mockFollowsCommandFactory).createFollowsCommand(eq("Charlie"), eq("Alice"));
        assertThat(command).isEqualTo(mockFollowsCommand);
    }

    @Test
    public void shouldReturnWallCommand() throws Exception {
        when(mockWallCommandFactory.createWallCommand(anyString())).thenReturn(mockWallCommand);
        Command command = passCommand("Charlie wall");
        verify(mockWallCommandFactory).createWallCommand(eq("Charlie"));
        assertThat(command).isEqualTo(mockWallCommand);
    }

    private Command passCommand(String userInput) {
        return new CommandFactory(mockExitCommandFactory, mockPostCommandFactory, mockViewTimelineCommandFactory, mockFollowsCommandFactory, mockWallCommandFactory).createCommand(userInput);
    }
}