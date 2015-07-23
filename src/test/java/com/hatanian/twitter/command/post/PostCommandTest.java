package com.hatanian.twitter.command.post;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostCommandTest {

    @Test
    public void shouldSavePost() throws Exception {
        User alice = new User("Alice");
        PostContent content = new PostContent("Message");
        PostRepository mockRepository = mock(PostRepository.class);
        PostCommand postCommand = new PostCommand(alice, content, mockRepository);
        postCommand.run();
        verify(mockRepository).save(new Post(alice, new PostContent("Message")));
    }
}