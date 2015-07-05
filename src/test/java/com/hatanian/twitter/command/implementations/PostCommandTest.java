package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.CommandTest;
import com.hatanian.twitter.domain.Message;
import com.hatanian.twitter.persistence.MessagesRepository;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class PostCommandTest extends CommandTest {

    private void runPostingCommand() {
        PostCommand postCommand = new PostCommand("Alice", "My message", new Date(1436084656162L));
        postCommand.run(getConsoleStream());
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