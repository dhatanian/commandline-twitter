package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.CommandTest;
import com.hatanian.twitter.domain.Message;
import com.hatanian.twitter.persistence.MessagesRepository;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class PostingCommandTest extends CommandTest {

    private void runPostingCommand() {
        PostingCommand postingCommand = new PostingCommand("Alice", "My message", new Date(1436084656162L));
        postingCommand.run(getConsoleStream());
    }

    @Test
    public void shouldStoreMessageInRepository() throws Exception {
        runPostingCommand();
        assertThat(MessagesRepository.getMessageList()).containsExactly(new Message("Alice", "My message", new Date(1436084656162L)));
    }

    @Test
    public void shouldNotOutputAnythingToConsole() {
        runPostingCommand();
        assertThat(getConsoleOutput()).isEmpty();
    }
}