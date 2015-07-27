package com.hatanian.twitter.command.post;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostCommandTest {
    @Mock
    PostRepository mockPostRepository;

    @Mock
    PostContent mockPostContent;

    @Mock
    User mockUser;

    @Test
    public void shouldSavePost() throws Exception {
        new PostCommand(mockPostRepository, mockUser, mockPostContent).run();
        verify(mockPostRepository).savePost(new Post(mockUser, mockPostContent));
    }
}