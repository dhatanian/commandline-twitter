package com.hatanian.twitter.console;

import java.io.*;

public class InputStreamConsoleImpl implements Console {
    BufferedReader bufferedReader;
    private static final String UTF_8 = "UTF-8";

    public InputStreamConsoleImpl(InputStream inputStream) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 does not seems supported", e);
        }
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}
