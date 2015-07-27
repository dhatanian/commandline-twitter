package com.hatanian.twitter.persistence;

import com.hatanian.twitter.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FolloweesRepositoryTest {
    @Mock
    User mockFollower;

    @Mock
    User mockFollowee;

    FolloweesRepository followeesRepository;

    @Before
    public void setUp() throws Exception {
        followeesRepository = new FolloweesRepository();
    }

    @Test
    public void shouldSaveFollowee() throws Exception {
        followeesRepository.saveFollowee(mockFollower, mockFollowee);
        assertThat(followeesRepository.followees.get(mockFollower)).containsExactly(mockFollowee);
    }

    @Test
    public void shouldFetchFollowees() throws Exception {
        followeesRepository.followees.put(mockFollower, Collections.singleton(mockFollowee));
        assertThat(followeesRepository.getFollowees(mockFollower)).containsExactly(mockFollowee);
    }
}