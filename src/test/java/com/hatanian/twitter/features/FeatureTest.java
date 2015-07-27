package com.hatanian.twitter.features;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hatanian.twitter.App;
import com.hatanian.twitter.ProgramTerminator;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.console.Console;
import com.hatanian.twitter.output.Output;
import org.junit.Before;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class FeatureTest {
    public static final long EXECUTION_INSTANT = 1437776421000L;
    @Mock
    Console console;
    @Spy
    Output out = new Output(System.out);
    @Mock
    ProgramTerminator programTerminator;
    ChangingClock clock = new ChangingClock(EXECUTION_INSTANT);
    PostsRepository postsRepository = new PostsRepository(clock);
    private int lineIndex;
    private List<TestUserInput> userInputList = new LinkedList<>();
    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        lineIndex = 0;
        inOrder = inOrder(out);
        when(console.readLine()).thenAnswer(invocation -> {
            if (lineIndex >= userInputList.size()) {
                throw new IllegalArgumentException("Unexpected command number " + 0);
            } else {
                TestUserInput testUserInput = userInputList.get(lineIndex);
                lineIndex++;
                clock.setCurrentTime(testUserInput.time);
                return testUserInput.userInput;
            }
        });
    }

    protected void registerUserInput(String userInput, int age, TimeUnit ageUnit) {
        userInputList.add(new TestUserInput(userInput, EXECUTION_INSTANT - ageUnit.toMillis(age)));
    }

    private class TestUserInput {
        private String userInput;
        private long time;

        public TestUserInput(String userInput, long time) {
            this.userInput = userInput;
            this.time = time;
        }
    }

    protected void runApp() {
        Injector injector = Guice.createInjector(new TestGuiceModule(console, out, programTerminator, clock, postsRepository));
        App app = injector.getInstance(App.class);
        app.run();
    }


    protected void expectOutput(String line) {
        inOrder.verify(out).println(line);
    }

    protected void expectUserAskedForCommand(int times) {
        inOrder.verify(out, times(times)).print("> ");
    }

    protected void verifyNoMoreOutput() {
        inOrder.verifyNoMoreInteractions();
    }
}
