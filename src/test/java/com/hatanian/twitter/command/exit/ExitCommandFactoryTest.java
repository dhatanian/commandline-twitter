package com.hatanian.twitter.command.exit;

import com.hatanian.twitter.ExitFlag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExitCommandFactoryTest {
    @Mock
    ExitFlag mockExitFlag;

    @Test
    public void shouldCreateExitCommand() throws Exception {
        assertThat(new ExitCommandFactory(mockExitFlag).createExitCommand()).isEqualTo(new ExitCommand(mockExitFlag));
    }
}