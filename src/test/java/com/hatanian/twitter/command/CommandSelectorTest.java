package com.hatanian.twitter.command;

import com.hatanian.twitter.command.implementations.PostCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Creation date 05/07/15.
 */
public class CommandSelectorTest {

    private PostCommand passPostCommand(String message) {
        return (PostCommand) CommandSelector.selectCommand("Alice -> " + message);
    }

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
        PostCommand command = passPostCommand("Message");
        assertThat(command.getMessage()).isEqualTo("Message");
    }

    /**
     * This reproduces a bug in early versions of the posting command, where the message would be cut at the first space.
     */
    @Test
    public void shouldAcceptMessagesWithSpacesInPostCommand() {
        PostCommand command = passPostCommand("Message with spaces");
        assertThat(command.getMessage()).isEqualTo("Message with spaces");
    }
}