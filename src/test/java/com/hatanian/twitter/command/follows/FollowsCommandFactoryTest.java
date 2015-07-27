package com.hatanian.twitter.command.follows;

import com.hatanian.twitter.persistence.FolloweesRepository;
import com.hatanian.twitter.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FollowsCommandFactoryTest {

    @Mock
    FolloweesRepository mockFolloweesRepository;

    @Test
    public void shouldCreateFollowsCommand() throws Exception {
        FollowsCommand followsCommand = new FollowsCommandFactory(mockFolloweesRepository).createFollowsCommand("Charlie", "Alice");
        assertThat(followsCommand).isEqualTo(new FollowsCommand(mockFolloweesRepository, new User("Charlie"), new User("Alice")));
    }
}