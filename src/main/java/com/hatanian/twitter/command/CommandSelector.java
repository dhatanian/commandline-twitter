package com.hatanian.twitter.command;

import com.hatanian.twitter.command.implementations.PostingCommand;

import java.io.StringReader;
import java.util.Date;
import java.util.Scanner;

public abstract class CommandSelector {
    public static Command selectCommand(String userInput) {
        try (Scanner scanner = new Scanner(new StringReader(userInput))) {

            //Based on the commands, we expect always one word
            String firstWord = scanner.next();
            //The second word might not exist if we're just reading the messages
            String secondWord = null;
            if (scanner.hasNext()) {
                secondWord = scanner.next();
            }

            if (secondWord != null && secondWord.equals("->")) {
                return new PostingCommand(firstWord, scanner.nextLine().trim(), new Date());
            }

            return null;
        }
    }
}
