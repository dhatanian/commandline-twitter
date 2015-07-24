package com.hatanian.twitter.output;

import com.hatanian.twitter.domain.Post;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Collections;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class OutputTest {

    @Test
    public void shouldPrintPosts() throws Exception {
        PrintStream mockPrintStream = mock(PrintStream.class);
        PostFormatter mockPostFormatter = mock(PostFormatter.class);
        Output output = new Output(mockPrintStream, mockPostFormatter);
        Post mockPost = mock(Post.class);

        when(mockPostFormatter.formatPost(eq(mockPost))).thenReturn("My formatted post");

        output.printPosts(Collections.singletonList(mockPost).stream());
        verify(mockPrintStream).println(eq("My formatted post"));
    }


}