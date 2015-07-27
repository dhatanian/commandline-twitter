package com.hatanian.twitter;

import com.hatanian.twitter.console.InputStreamConsoleImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GuiceModuleTest {

    @Test
    public void shouldGetSystemInConsoleImplementation() throws Exception {
        assertThat(new GuiceModule().getSystemConsoleOrSystemInIDEs()).isInstanceOf(InputStreamConsoleImpl.class);
    }
}