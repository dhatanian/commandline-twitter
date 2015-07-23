package com.hatanian.twitter.command.post;

import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PostCommandFactoryTest {

    @Test
    public void shouldBuildPostCommand() throws Exception {
        User mockUser = mock(User.class);
        PostContent mockPostContent = mock(PostContent.class);
        PostRepository mockPostRepository = mock(PostRepository.class);

        PostCommand postCommand = new PostCommandFactory(mockPostRepository).buildPostCommand(mockUser, mockPostContent);
        assertThat(postCommand).isEqualTo(new PostCommand(mockUser, mockPostContent, mockPostRepository));
    }


}