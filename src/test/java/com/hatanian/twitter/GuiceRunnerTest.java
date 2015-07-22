package com.hatanian.twitter;

import com.google.inject.Injector;
import com.hatanian.twitter.app.App;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GuiceRunnerTest {
    @Test
    public void shouldRunAppImplementation() throws IOException {
        Injector mockInjector = mock(Injector.class);
        App mockApp = mock(App.class);
        when(mockInjector.getInstance(any(Class.class))).thenReturn(mockApp);
        GuiceRunner.setInjector(mockInjector);

        GuiceRunner.main(null);

        verify(mockApp).run();
    }
}