package com.hatanian.twitter.command;

import com.hatanian.twitter.command.wall.WallService;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.persistence.PostsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WallServiceTest {
    @Mock
    PostsRepository mockPostsRepository;
    @Mock
    FolloweesRepository mockFolloweesRepository;
    @Mock
    User mockUser;
    @Mock
    Post mockUserPost;
    @Mock
    User mockFollowee;
    @Mock
    Post mockFolloweePost;

    WallService wallService;

    @Before
    public void setUp() throws Exception {
        wallService = new WallService(mockFolloweesRepository, mockPostsRepository);
    }


    @Test
    public void shouldIncludeActualUsersPosts() throws Exception {
        userHasOnePost();
        Object[] wall = callWallService();
        assertThat(wall).containsExactly(mockUserPost);
    }

    @Test
    public void shouldIncludeFolloweesPosts() throws Exception {
        followeeHasOnePost();
        Object[] wall = callWallService();
        assertThat(wall).containsExactly(mockFolloweePost);
    }

    @Test
    public void shouldReturnNewestPostsFirst() throws Exception {
        userHasOnePost();
        followeeHasOnePost();
        usersPostIsOlder();
        Object[] wall = callWallService();
        assertThat(wall).containsExactly(mockFolloweePost, mockUserPost);
    }

    private void usersPostIsOlder() {
        when(mockUserPost.getCreationDate()).thenReturn(new Date(1437776421000L - 100L));
        when(mockFolloweePost.getCreationDate()).thenReturn(new Date(1437776421000L));
    }

    private void followeeHasOnePost() {
        when(mockPostsRepository.getUserTimeline(eq(mockFollowee))).thenReturn(Collections.singleton(mockFolloweePost).stream());
        when(mockFolloweesRepository.getFollowees(eq(mockUser))).thenReturn(Collections.singleton(mockFollowee));
    }

    private void userHasOnePost() {
        when(mockPostsRepository.getUserTimeline(eq(mockUser))).thenReturn(Collections.singleton(mockUserPost).stream());
    }

    private Object[] callWallService() {
        return wallService.getUserWall(mockUser).toArray();
    }
}