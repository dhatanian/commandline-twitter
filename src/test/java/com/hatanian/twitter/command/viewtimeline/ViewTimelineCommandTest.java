package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class ViewTimelineCommandTest {
    PostRepository mockPostRepository;
    User mockUser;
    Output mockOutput;
    ViewTimelineCommand viewTimelineCommand;

    @Before
    public void setUp() throws Exception {
        mockPostRepository = mock(PostRepository.class);
        mockOutput = mock(Output.class);
        mockUser = mock(User.class);
        viewTimelineCommand = new ViewTimelineCommand(mockPostRepository, mockUser, mockOutput);
    }

    @Test
    public void shouldRetrieveUserTimeline() throws Exception {
        viewTimelineCommand.run();
        verify(mockPostRepository).getUserTimeline(eq(mockUser));
    }

    @Test
    public void shouldDisplayUserTimeline() throws Exception {
        Stream<Post> posts = new ArrayList<Post>().stream();
        when(mockPostRepository.getUserTimeline(eq(mockUser))).thenReturn(posts);
        viewTimelineCommand.run();
        verify(mockOutput).printPosts(eq(posts));
    }
}