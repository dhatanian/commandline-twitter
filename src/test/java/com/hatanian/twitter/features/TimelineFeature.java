package com.hatanian.twitter.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.TimeUnit;

@RunWith(MockitoJUnitRunner.class)
public class TimelineFeature extends FeatureTest {

    @Test
    public void shouldDisplayTimelineWithAddedPostsAndExit() throws Exception {
        registerUserInput("Alice -> Post 1", 1, TimeUnit.MINUTES);
        registerUserInput("Alice -> Post 2", 10, TimeUnit.MILLISECONDS);
        registerUserInput("Bob -> Unrelated post", 10, TimeUnit.MILLISECONDS);
        registerUserInput("Alice", 0, TimeUnit.MILLISECONDS);
        registerUserInput("exit", 0, TimeUnit.MILLISECONDS);

        runApp();

        expectOutput("Welcome on this Command Line social network !");
        expectUserAskedForCommand(4);
        expectOutput("Post 2 (moments ago)");
        expectOutput("Post 1 (1 minute ago)");
        expectUserAskedForCommand(1);
        expectOutput("Thank you, good bye !");
        verifyNoMoreOutput();
    }

}
