package com.hatanian.twitter.console;

import java.io.*;

public class InputStreamConsoleImpl implements Console {
    private BufferedReader systemInReader;

    public InputStreamConsoleImpl(InputStream inputStream) {
        try {
            systemInReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding does not seem to be supported", e);
        }
    }

    @Override
    public String readLine() throws IOException {
        return systemInReader.readLine();
    }
}
