package com.hatanian.twitter;

import com.google.inject.Injector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GuiceRunnerTest {

    @Mock
    App mockApp;

    @Test
    public void shouldRunAppImplementation() throws IOException {
        Injector mockInjector = mock(Injector.class);
        when(mockInjector.getInstance(eq(App.class))).thenReturn(mockApp);

        GuiceRunner.setInjector(mockInjector);
        GuiceRunner.main(new String[]{});

        verify(mockApp).run();
    }
}
