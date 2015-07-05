package com.hatanian.twitter.command.implementations;

import com.hatanian.twitter.command.CommandTest;
import com.hatanian.twitter.persistence.FolloweesRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FollowCommandTest extends CommandTest {

    @Test
    public void shouldAddFolloweeToUser() throws Exception {
        runFollowCommand();
        assertThat(FolloweesRepository.getFollowees("Charlie")).containsExactly("Alice");
    }

    @Test
    public void shouldNotOutputAnythingToConsole() {
        runFollowCommand();
        assertThat(getConsoleOutput()).isEmpty();
    }

    private void runFollowCommand() {
        new FollowCommand("Charlie", "Alice").run(getConsoleStream());
    }
}