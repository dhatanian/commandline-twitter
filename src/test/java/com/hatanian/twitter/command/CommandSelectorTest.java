package com.hatanian.twitter.command;

import com.hatanian.twitter.command.implementations.PostingCommand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Creation date 05/07/15.
 */
public class CommandSelectorTest {

    private PostingCommand passPostingCommand(String message) {
        return (PostingCommand) CommandSelector.selectCommand("Alice -> " + message);
    }

    @Test
    public void shouldReturnPostingCommand() throws Exception {
        Command command = passPostingCommand("Message");
        assertThat(command).isInstanceOf(PostingCommand.class);
    }

    @Test
    public void shouldSetUserNameInPostingCommand() {
        Command command = passPostingCommand("Message");
        assertThat(command.getUser()).isEqualTo("Alice");
    }

    @Test
    public void shouldSetMessageInPostingCommand() {
        PostingCommand command = passPostingCommand("Message");
        assertThat(command.getMessage()).isEqualTo("Message");
    }

    /**
     * This reproduces a bug in early versions of the posting command, where the message would be cut at the first space.
     */
    @Test
    public void shouldAcceptMessagesWithSpacesInPostingCommand() {
        PostingCommand command = passPostingCommand("Message with spaces");
        assertThat(command.getMessage()).isEqualTo("Message with spaces");
    }
}