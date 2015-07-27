package com.hatanian.twitter.console;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStreamConsoleImplTest {

    @Test
    public void shouldReadLine() throws Exception {
        String input = "line 1" + System.lineSeparator() + "line 2";
        InputStreamConsoleImpl inputStreamConsole = new InputStreamConsoleImpl(new ByteArrayInputStream(input.getBytes("utf-8")));
        assertThat(inputStreamConsole.readLine()).isEqualTo("line 1");
        assertThat(inputStreamConsole.readLine()).isEqualTo("line 2");
    }
}