package com.hatanian.twitter.command.post;

import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PostCommandFactoryTest {
    @Mock
    PostsRepository mockPostsRepository;

    @Test
    public void shouldCreatePostCommand() throws Exception {
        assertThat(new PostCommandFactory(mockPostsRepository).createPostCommand("Alice", "My message")).isEqualTo(new PostCommand(mockPostsRepository, new User("Alice"), new PostContent("My message")));
    }
}