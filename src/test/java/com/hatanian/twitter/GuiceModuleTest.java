package com.hatanian.twitter;

import com.hatanian.twitter.console.InputStreamConsoleImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GuiceModuleTest {

    @Test
    public void shouldReturnInputStreamConsoleInUnitTests() throws Exception {
        assertThat(new GuiceModule().getConsole()).isInstanceOf(InputStreamConsoleImpl.class);
    }
}