package com.hatanian.twitter.command;

import com.hatanian.twitter.command.exit.ExitCommand;
import com.hatanian.twitter.command.exit.ExitCommandFactory;
import com.hatanian.twitter.command.post.PostCommand;
import com.hatanian.twitter.command.post.PostCommandFactory;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommand;
import com.hatanian.twitter.command.viewtimeline.ViewTimelineCommandFactory;
import com.hatanian.twitter.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandFactoryTest {
    private PostCommandFactory mockPostCommandFactory;
    private ExitCommandFactory mockExitCommandFactory;
    private ViewTimelineCommandFactory mockViewTimelineCommandFactory;

    @Before
    public void setUp() throws Exception {
        mockPostCommandFactory = mock(PostCommandFactory.class);
        mockExitCommandFactory = mock(ExitCommandFactory.class);
        mockViewTimelineCommandFactory = mock(ViewTimelineCommandFactory.class);
    }

    @Test
    public void shouldReturnExitCommand() throws Exception {
        ExitCommand mockExitCommand = mock(ExitCommand.class);
        when(mockExitCommandFactory.buildExitCommand()).thenReturn(mockExitCommand);
        Command command = passCommand("exit");
        assertThat(command).isEqualTo(mockExitCommand);
    }

    @Test
    public void shouldReturnPostCommand() throws Exception {
        PostCommand mockPostCommand = mock(PostCommand.class);
        when(mockPostCommandFactory.buildPostCommand(any(), any())).thenReturn(mockPostCommand);
        Command command = passCommand("Alice -> Post");
        assertThat(command).isEqualTo(mockPostCommand);
    }

    @Test
    public void shouldReturnViewTimelineCommand() throws Exception {
        ViewTimelineCommand mockViewTimelineCommand = mock(ViewTimelineCommand.class);
        when(mockViewTimelineCommandFactory.buildViewTimelineCommand(eq(new User("Alice")))).thenReturn(mockViewTimelineCommand);
        Command command = passCommand("Alice");
        assertThat(command).isEqualTo(mockViewTimelineCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNoMatchIsFound() {
        passCommand("a b");
    }

    private Command passCommand(String userInput) {
        return new CommandFactory(mockExitCommandFactory, mockPostCommandFactory, mockViewTimelineCommandFactory).buildCommandFromUserInput(userInput);
    }


}