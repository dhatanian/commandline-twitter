package com.hatanian.twitter.command.post;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.persistence.PostsRepository;
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
    PostsRepository mockPostsRepository;

    @Mock
    PostContent mockPostContent;

    @Mock
    User mockUser;

    @Test
    public void shouldSavePost() throws Exception {
        new PostCommand(mockPostsRepository, mockUser, mockPostContent).run();
        verify(mockPostsRepository).savePost(new Post(mockUser, mockPostContent));
    }
}