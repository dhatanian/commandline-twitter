package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.After;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostRepositoryTest {
    PostRepository inMemoryPostRepository = new PostRepository(Clock.fixed(Instant.ofEpochMilli(1437776421000L), ZoneId.of("UTC")));

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

    @Test
    public void shouldSetPostCreationDateWhenSaving() throws Exception {
        Post mockPost = mock(Post.class);
        inMemoryPostRepository.save(mockPost);
        verify(mockPost).setCreationDate(eq(new Date(1437776421000L)));
    }

    @Test
    public void shouldReturnUserTimeline() throws Exception {
        Post alicesPost = new Post(new User("Alice"), new PostContent("Text"));
        PostRepository.postList.add(alicesPost);

        Post bobsPost = new Post(new User("Bob"), new PostContent("Text"));
        PostRepository.postList.add(bobsPost);

        assertThat(inMemoryPostRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesPost);
    }

    @Test
    public void shouldReturnMessagesOrderedByDecrescentDateInTimeline() {
        long currentTime = 1437776421000L;
        Post alicesFirstPost = new Post(new User("Alice"), new PostContent("Text"));
        alicesFirstPost.setCreationDate(new Date(currentTime - 2000));
        Post alicesSecondPost = new Post(new User("Alice"), new PostContent("Text2"));
        alicesSecondPost.setCreationDate(new Date(currentTime - 1000));
        PostRepository.postList.add(alicesFirstPost);
        PostRepository.postList.add(alicesSecondPost);

        assertThat(inMemoryPostRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesSecondPost, alicesFirstPost);
    }

}