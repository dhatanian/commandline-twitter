package com.hatanian.twitter;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.command.CommandSelector;

import java.io.*;

public class App {
    private static Console console = System.console();
    private static BufferedReader systemInReader;

    static {
        if (console == null) {
            //When running from a IDE, there might not be a console, so we're reading from System.in and assuming the charset is UTF-8
            try {
                systemInReader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 encoding does not seem to be supported", e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome on this Command Line social network !");
        while (true) {
            System.out.print("> ");
            String userInput = readLineFromConsole();
            processUserInput(userInput);
        }
    }

    private static String readLineFromConsole() {
        if (console != null) {
            return console.readLine();
        } else {
            try {
                return systemInReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Error when reading from System.in", e);
            }
        }
    }

    private static void processUserInput(String userInput) {
        Command command = CommandSelector.selectCommand(userInput);
        command.run(System.out);
    }
}
