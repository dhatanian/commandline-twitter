package com.hatanian.twitter.command;

import com.hatanian.twitter.command.wall.WallCommand;
import com.hatanian.twitter.command.wall.WallService;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.output.PostFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WallCommandTest {
    @Mock
    User mockUser;
    @Mock
    Post mockPost1;
    @Mock
    Post mockPost2;
    @Mock
    Output mockOutput;
    @Mock
    PostFormatter mockPostFormatter;
    @Mock
    WallService mockWallService;

    @Before
    public void setUp() throws Exception {
        when(mockWallService.getUserWall(any())).thenReturn(Arrays.asList(mockPost1, mockPost2).stream());
        when(mockPostFormatter.formatForWall(eq(mockPost1))).thenReturn("Post1");
        when(mockPostFormatter.formatForWall(eq(mockPost2))).thenReturn("Post2");
    }

    @Test
    public void shouldGetPostsFromWallService() throws Exception {
        runCommand();
        verify(mockWallService).getUserWall(eq(mockUser));
    }

    @Test
    public void shouldPassPostsToPostFormatter() throws Exception {
        runCommand();
        verify(mockPostFormatter).formatForWall(eq(mockPost1));
        verify(mockPostFormatter).formatForWall(eq(mockPost2));
    }

    @Test
    public void shouldDisplayFormattedPosts() throws Exception {
        runCommand();
        verify(mockOutput).println("Post2");
        verify(mockOutput).println("Post1");
    }

    private void runCommand() {
        new WallCommand(mockWallService, mockOutput, mockPostFormatter, mockUser).run();
    }
}