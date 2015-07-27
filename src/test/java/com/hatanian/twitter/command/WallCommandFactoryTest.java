package com.hatanian.twitter.command;

import com.hatanian.twitter.command.wall.WallCommand;
import com.hatanian.twitter.command.wall.WallCommandFactory;
import com.hatanian.twitter.command.wall.WallService;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.output.PostFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WallCommandFactoryTest {
    @Mock
    WallService mockWallService;

    @Mock
    Output mockOutput;

    @Mock
    PostFormatter mockPostFormatter;

    @Test
    public void shouldCreateWallCommand() throws Exception {
        WallCommand wallCommand = new WallCommandFactory(mockWallService, mockOutput, mockPostFormatter).createWallCommand("Charlie");
        assertThat(wallCommand).isEqualTo(new WallCommand(mockWallService, mockOutput, mockPostFormatter, new User("Charlie")));
    }
}