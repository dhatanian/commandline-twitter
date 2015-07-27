package com.hatanian.twitter.command.follows;

import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FollowsCommandTest {
    @Mock
    User mockFollower;

    @Mock
    User mockFollowee;

    @Mock
    FolloweesRepository mockFolloweesRepository;

    @Test
    public void shouldStoreNewFollowee() throws Exception {
        FollowsCommand followsCommand = new FollowsCommand(mockFolloweesRepository, mockFollower, mockFollowee);
        followsCommand.run();
        verify(mockFolloweesRepository).saveFollowee(eq(mockFollower), eq(mockFollowee));
    }
}