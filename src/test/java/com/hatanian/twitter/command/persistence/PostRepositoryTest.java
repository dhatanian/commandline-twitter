package com.hatanian.twitter.command.persistence;

import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostRepositoryTest {
    @Mock
    Post mockPost;

    PostRepository postRepository = new PostRepository(Clock.fixed(Instant.ofEpochMilli(1437776421000L), ZoneId.of("UTC")));

    @Test
    public void shouldSavePostInPostList() throws Exception {
        Post post = new Post(new User("Alice"), new PostContent("My message"));
        postRepository.savePost(post);
        assertThat(postRepository.postList).containsExactly(post);
    }

    @Test
    public void shouldSetPostCreationDateWhenSaving() throws Exception {
        postRepository.savePost(mockPost);
        verify(mockPost).setCreationDate(eq(new Date(1437776421000L)));
    }

    @Test
    public void shouldReturnUserTimeline() throws Exception {
        Post alicesPost = new Post(new User("Alice"), new PostContent("Text"));
        postRepository.postList.add(alicesPost);

        Post bobsPost = new Post(new User("Bob"), new PostContent("Text"));
        postRepository.postList.add(bobsPost);

        assertThat(postRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesPost);
    }

    @Test
    public void shouldReturnMessagesOrderedByDecrescentDateInTimeline() {
        long currentTime = 1437776421000L;
        Post alicesFirstPost = new Post(new User("Alice"), new PostContent("Text"));
        alicesFirstPost.setCreationDate(new Date(currentTime - 2000));
        Post alicesSecondPost = new Post(new User("Alice"), new PostContent("Text2"));
        alicesSecondPost.setCreationDate(new Date(currentTime - 1000));
        postRepository.postList.add(alicesFirstPost);
        postRepository.postList.add(alicesSecondPost);

        assertThat(postRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesSecondPost, alicesFirstPost);
    }

}