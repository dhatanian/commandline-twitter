package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostsRepository;
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
    PostsRepository mockPostsRepository;
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
        when(mockPostsRepository.getUserTimeline(eq(mockUser))).thenReturn(posts);
        when(mockPostFormatter.format(eq(mockPost))).thenReturn("formatted post");
        viewTimelineCommand = new ViewTimelineCommand(mockPostsRepository, mockUser, mockOutput, mockPostFormatter);
    }

    @Test
    public void shouldRetrieveUserTimeline() throws Exception {
        viewTimelineCommand.run();
        verify(mockPostsRepository).getUserTimeline(eq(mockUser));
    }

    public void shouldConvertUsersTimelinePostsToStringAndDisplayIt() throws Exception {
        viewTimelineCommand.run();
        verify(mockOutput).println("formatted post");
    }

}