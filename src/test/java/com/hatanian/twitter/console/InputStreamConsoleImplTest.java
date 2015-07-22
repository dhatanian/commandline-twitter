package com.hatanian.twitter.console;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStreamConsoleImplTest {
    @Test
    public void shoudReadLineFromSourceInputStream() throws Exception {
        String source = "line 1" + System.lineSeparator() + "line 2";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source.getBytes("utf-8"));
        String line = new InputStreamConsoleImpl(byteArrayInputStream).readLine();
        assertThat(line).isEqualTo("line 1");
        byteArrayInputStream.close();
    }
}