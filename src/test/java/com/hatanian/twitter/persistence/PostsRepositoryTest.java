package com.hatanian.twitter.persistence;

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
public class PostsRepositoryTest {
    @Mock
    Post mockPost;

    PostsRepository postsRepository = new PostsRepository(Clock.fixed(Instant.ofEpochMilli(1437776421000L), ZoneId.of("UTC")));

    @Test
    public void shouldSavePostInPostList() throws Exception {
        Post post = new Post(new User("Alice"), new PostContent("My message"));
        postsRepository.savePost(post);
        assertThat(postsRepository.postList).containsExactly(post);
    }

    @Test
    public void shouldSetPostCreationDateWhenSaving() throws Exception {
        postsRepository.savePost(mockPost);
        verify(mockPost).setCreationDate(eq(new Date(1437776421000L)));
    }

    @Test
    public void shouldReturnUserTimeline() throws Exception {
        Post alicesPost = new Post(new User("Alice"), new PostContent("Text"));
        postsRepository.postList.add(alicesPost);

        Post bobsPost = new Post(new User("Bob"), new PostContent("Text"));
        postsRepository.postList.add(bobsPost);

        assertThat(postsRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesPost);
    }

    @Test
    public void shouldReturnMessagesOrderedByDecrescentDateInTimeline() {
        long currentTime = 1437776421000L;
        Post alicesFirstPost = new Post(new User("Alice"), new PostContent("Text"));
        alicesFirstPost.setCreationDate(new Date(currentTime - 2000));
        Post alicesSecondPost = new Post(new User("Alice"), new PostContent("Text2"));
        alicesSecondPost.setCreationDate(new Date(currentTime - 1000));
        postsRepository.postList.add(alicesFirstPost);
        postsRepository.postList.add(alicesSecondPost);

        assertThat(postsRepository.getUserTimeline(new User("Alice")).toArray()).containsExactly(alicesSecondPost, alicesFirstPost);
    }

}