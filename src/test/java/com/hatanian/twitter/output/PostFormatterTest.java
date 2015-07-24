package com.hatanian.twitter.output;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostFormatterTest {

    @Test
    public void shouldReturnPostContentAndFormattedTime() throws Exception {
        TimeFormatter mockTimeFormatter = mock(TimeFormatter.class);
        when(mockTimeFormatter.formatDateAsTimePastSince(any())).thenReturn("a long long time ago");

        PostFormatter postFormatter = new PostFormatter(mockTimeFormatter);

        Post post = new Post(mock(User.class), new PostContent("My content"));
        String formattedPost = postFormatter.formatPost(post);
        assertThat(formattedPost).isEqualTo("My content (a long long time ago)");
    }


}