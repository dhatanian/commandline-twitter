package com.hatanian.twitter.output;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostFormatterTest {
    @Mock
    TimeFormatter mockTimeFormatter;

    @Test
    public void shouldReturnPostContentAndFormattedTime() throws Exception {
        when(mockTimeFormatter.formatDateAsTimePastSince(any())).thenReturn("a long long time ago");

        PostFormatter postFormatter = new PostFormatter(mockTimeFormatter);

        Post post = new Post(mock(User.class), new PostContent("My content"));
        String formattedPost = postFormatter.format(post);
        assertThat(formattedPost).isEqualTo("My content (a long long time ago)");
    }


}