package com.hatanian.twitter.command;

import com.hatanian.twitter.persistence.TestUsingMessagesRepository;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public abstract class CommandTest extends TestUsingMessagesRepository {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream consoleStream;

    @Before
    public void setUpConsoleStream() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        consoleStream = new PrintStream(byteArrayOutputStream);
    }

    @After
    public void closeStreams() {
        consoleStream.close();
    }

    public PrintStream getConsoleStream() {
        return consoleStream;
    }

    public String getConsoleOutput() {
        try {
            return byteArrayOutputStream.toString("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
