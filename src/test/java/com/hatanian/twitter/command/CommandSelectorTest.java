package com.hatanian.twitter.command;

import com.hatanian.twitter.command.implementations.PostCommand;
import com.hatanian.twitter.command.implementations.ViewTimelineCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Creation date 05/07/15.
 */
public class CommandSelectorTest {

    @Test
    public void shouldReturnPostCommand() throws Exception {
        Command command = passPostCommand("Message");
        assertThat(command).isInstanceOf(PostCommand.class);
    }

    @Test
    public void shouldSetUserNameInPostCommand() {
        Command command = passPostCommand("Message");
        assertThat(command.getUser()).isEqualTo("Alice");
    }

    @Test
    public void shouldSetMessageInPostCommand() {
        PostCommand command = (PostCommand) passPostCommand("Message");
        assertThat(command.getMessage()).isEqualTo("Message");
    }

    /**
     * This reproduces a bug in early versions of the posting command, where the message would be cut at the first space.
     */
    @Test
    public void shouldAcceptMessagesWithSpacesInPostCommand() {
        PostCommand command = (PostCommand) passPostCommand("Message with spaces");
        assertThat(command.getMessage()).isEqualTo("Message with spaces");
    }

    @Test
    public void shouldReturnViewTimelineCommand() {
        Command viewTimelineCommand = passViewTimelineCommand();
        assertThat(viewTimelineCommand).isInstanceOf(ViewTimelineCommand.class);
    }

    @Test
    public void shouldSetUserNameInViewTimelineCommand() {
        ViewTimelineCommand viewTimelineCommand = (ViewTimelineCommand) passViewTimelineCommand();
        assertThat(viewTimelineCommand.getUser()).isEqualTo("Alice");
    }

    private Command passPostCommand(String message) {
        return CommandSelector.selectCommand("Alice -> " + message);
    }

    private Command passViewTimelineCommand() {
        return CommandSelector.selectCommand("Alice");
    }
}