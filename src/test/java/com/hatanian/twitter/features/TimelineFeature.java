package com.hatanian.twitter.features;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hatanian.twitter.App;
import com.hatanian.twitter.ProgramTerminator;
import com.hatanian.twitter.command.persistence.PostRepository;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.output.Output;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TimelineFeature {
    public static final long EXECUTION_INSTANT = 1437776421000L;
    @Mock
    Console console;
    @Mock
    Output out;
    @Mock
    ProgramTerminator programTerminator;

    ChangingClock clock = new ChangingClock(EXECUTION_INSTANT);
    PostRepository postRepository = new PostRepository(clock);
    int lineIndex;

    @Before
    public void setUp() throws Exception {
        lineIndex = 0;
    }

    @Test
    public void shouldDisplayTimelineWithAddedPostsAndExit() throws Exception {
        when(console.readLine()).thenAnswer(invocation -> {
            switch (lineIndex++) {
                case 0:
                    clock.setCurrentTime(EXECUTION_INSTANT - 60 * 1000);
                    return "Alice -> Post 1";
                case 1:
                    clock.setCurrentTime(EXECUTION_INSTANT - 10);
                    return "Alice -> Post 2";
                case 2:
                    return "Bob -> Unrelated post";
                case 3:
                    clock.setCurrentTime(EXECUTION_INSTANT);
                    return "Alice";
                case 4:
                    return "exit";
                default:
                    throw new IllegalArgumentException("Unexpected command number " + 0);
            }
        });

        Injector injector = Guice.createInjector(new TestGuiceModule(console, out, programTerminator, clock, postRepository));
        App app = injector.getInstance(App.class);
        app.run();

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome on this Command Line social network !");
        inOrder.verify(out, times(4)).print("> ");
        inOrder.verify(out).println("Post 2 (moments ago)");
        inOrder.verify(out).println("Post 1 (1 minute ago)");
        inOrder.verify(out).print("> ");
        inOrder.verify(out).println("Thank you, good bye !");
        inOrder.verifyNoMoreInteractions();
    }

}
