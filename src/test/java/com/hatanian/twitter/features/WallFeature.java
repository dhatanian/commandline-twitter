package com.hatanian.twitter.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.TimeUnit;

@RunWith(MockitoJUnitRunner.class)
public class WallFeature extends FeatureTest {
    @Test
    public void shouldLetUsersFollowOthersAndSeeTheirMessagesOnTheirWalls() throws Exception {
        registerUserInput("Alice -> I love the weather today", 5, TimeUnit.MINUTES);
        registerUserInput("Bob -> Damn! We lost!", 2, TimeUnit.MINUTES);
        registerUserInput("Bob -> Good game though.", 1, TimeUnit.MINUTES);
        registerUserInput("Charlie -> I'm in New York today! Anyone want to have a coffee?", 2, TimeUnit.SECONDS);
        registerUserInput("Charlie follows Alice", 0, TimeUnit.MILLISECONDS);
        registerUserInput("Charlie wall", 0, TimeUnit.MILLISECONDS);
        registerUserInput("Charlie follows Bob", 0, TimeUnit.MILLISECONDS);
        registerUserInput("Charlie wall", -13, TimeUnit.SECONDS);
        registerUserInput("exit", -13, TimeUnit.SECONDS);

        runApp();

        expectOutput("Welcome on this Command Line social network !");
        expectUserAskedForCommand(6);
        expectOutput("Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)");
        expectOutput("Alice - I love the weather today (5 minutes ago)");
        expectUserAskedForCommand(2);
        expectOutput("Charlie - I'm in New York today! Anyone want to have a coffee? (15 seconds ago)");
        expectOutput("Bob - Good game though. (1 minute ago)");
        expectOutput("Bob - Damn! We lost! (2 minutes ago)");
        expectOutput("Alice - I love the weather today (5 minutes ago)");
        expectUserAskedForCommand(1);
        expectOutput("Thank you, good bye !");
        verifyNoMoreOutput();
    }
}
