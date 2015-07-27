package com.hatanian.twitter.command.post;

import com.hatanian.twitter.command.persistence.PostRepository;
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
    PostRepository mockPostRepository;

    @Test
    public void shouldCreatePostCommand() throws Exception {
        assertThat(new PostCommandFactory(mockPostRepository).createPostCommand("Alice", "My message")).isEqualTo(new PostCommand(mockPostRepository, new User("Alice"), new PostContent("My message")));
    }
}