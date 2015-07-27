package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ViewTimelineCommandTest {
    @Mock
    PostRepository mockPostRepository;
    @Mock
    User mockUser;
    @Mock
    Post mockPost;
    @Mock
    Output mockOutput;
    @Mock
    PostFormatter mockPostFormatter;

    ViewTimelineCommand viewTimelineCommand;

    @Before
    public void setUp() throws Exception {
        Stream<Post> posts = Collections.singletonList(mockPost).stream();
        when(mockPostRepository.getUserTimeline(eq(mockUser))).thenReturn(posts);
        when(mockPostFormatter.format(eq(mockPost))).thenReturn("formatted post");
        viewTimelineCommand = new ViewTimelineCommand(mockPostRepository, mockUser, mockOutput, mockPostFormatter);
    }

    @Test
    public void shouldRetrieveUserTimeline() throws Exception {
        viewTimelineCommand.run();
        verify(mockPostRepository).getUserTimeline(eq(mockUser));
    }

    public void shouldConvertUsersTimelinePostsToStringAndDisplayIt() throws Exception {
        viewTimelineCommand.run();
        verify(mockOutput).println("formatted post");
    }

}