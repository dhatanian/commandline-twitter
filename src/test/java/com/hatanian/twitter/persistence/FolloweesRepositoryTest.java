package com.hatanian.twitter.persistence;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FolloweesRepositoryTest extends TestUsingPersistence{

    @Test
    public void shouldAddNewFolloweesToUser() throws Exception {
        FolloweesRepository.addFollowee("Charlie", "Alice");
        assertThat(FolloweesRepository.getFollowees()).hasSize(1);
        assertThat(FolloweesRepository.getFollowees()).containsKey("Charlie");
        assertThat(FolloweesRepository.getFollowees().get("Charlie")).containsExactly("Alice");
    }

    @Test
    public void shouldRetrieveFollowees() throws Exception {
        FolloweesRepository.addFollowee("Charlie", "Alice");
        assertThat(FolloweesRepository.getFollowees("Charlie")).containsExactly("Alice");
    }
}