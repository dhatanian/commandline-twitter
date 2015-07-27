package com.hatanian.twitter.output;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostFormatterTest {
    @Mock
    TimeFormatter mockTimeFormatter;

    @Mock
    User mockUser;

    PostFormatter postFormatter;
    Post post;

    @Before
    public void setUp() throws Exception {
        when(mockTimeFormatter.formatDateAsTimePastSince(any())).thenReturn("a long long time ago");
        when(mockUser.getId()).thenReturn("Alice");
        postFormatter = new PostFormatter(mockTimeFormatter);
        post = new Post(mockUser, new PostContent("My content"));
    }

    @Test
    public void shouldReturnPostContentAndFormattedTime() throws Exception {
        String formattedPost = postFormatter.format(post);
        assertThat(formattedPost).isEqualTo("My content (a long long time ago)");
    }

    @Test
    public void shouldReturnAuthorNameAsWellForWall() throws Exception {
        String formattedPost = postFormatter.formatForWall(post);
        assertThat(formattedPost).isEqualTo("Alice - My content (a long long time ago)");
    }
}