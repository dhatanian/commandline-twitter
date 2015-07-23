package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Post;
import org.junit.After;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PostRepositoryTest {
    PostRepository inMemoryPostRepository = new PostRepository();

    @After
    public void tearDown() throws Exception {
        PostRepository.postList.clear();
    }

    @Test
    public void shouldSave() throws Exception {
        Post mockPost = mock(Post.class);
        inMemoryPostRepository.save(mockPost);
        assertThat(PostRepository.postList).containsExactly(mockPost);
    }
}