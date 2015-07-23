package com.hatanian.twitter.command.exit;

import com.hatanian.twitter.exit.ExitFlag;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class ExitCommandFactoryTest {

    @Test
    public void shouldBuildExitCommand() throws Exception {
        ExitFlag mockExitFlag = mock(ExitFlag.class);
        ExitCommand exitCommand = new ExitCommandFactory(mockExitFlag).buildExitCommand();
        assertThat(exitCommand).isEqualTo(new ExitCommand(mockExitFlag));
    }
}