package com.hatanian.twitter.output;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OutputTest {
    @Mock
    PrintStream mockPrintStream;
    Output output;

    @Before
    public void setUp() throws Exception {
        output = new Output(mockPrintStream);
    }


    @Test
    public void shouldCallDelegatePrintln() throws Exception {
        output.println("the line");
        verify(mockPrintStream).println(eq("the line"));
    }


    @Test
    public void shouldCallDelegatePrint() throws Exception {
        output.print("the text");
        verify(mockPrintStream).print(eq("the text"));
    }
}