package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.CommandTest;
import com.hatanian.twitter.domain.Message;
import com.hatanian.twitter.persistence.MessagesRepository;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTimelineCommandTest extends CommandTest {

    @Test
    public void shouldOutputOneLinePerMessage() {
        MessagesRepository.getMessageList().add(new Message("Alice", "Message 1", new Date()));
        MessagesRepository.getMessageList().add(new Message("Alice", "Message 2", new Date()));
        new ViewTimelineCommand("Alice").run(getConsoleStream());
        assertThat(getConsoleOutput()).hasLineCount(2);
    }

    @Test
    public void shouldOutputMessageTextFirstThenTime() {
        MessagesRepository.getMessageList().add(new Message("Alice", "Message 1", new Date(System.currentTimeMillis() - 500L)));
        new ViewTimelineCommand("Alice").run(getConsoleStream());
        assertThat(getConsoleOutput()).isEqualTo("Message 1 (moments ago)" + System.lineSeparator());
    }
}