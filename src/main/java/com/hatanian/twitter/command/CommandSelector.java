package com.hatanian.twitter.command;

import com.hatanian.twitter.command.implementations.ExitCommand;
import com.hatanian.twitter.command.implementations.PostCommand;
import com.hatanian.twitter.command.implementations.ViewTimelineCommand;

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

            //Special "exit" command
            if (firstWord.equals("exit")) {
                return new ExitCommand();
            }

            //Pattern <username>
            if (secondWord == null) {
                return new ViewTimelineCommand(firstWord);
            }

            //Pattern <username> -> <message>
            if (secondWord != null && secondWord.equals("->")) {
                return new PostCommand(firstWord, scanner.nextLine().trim(), new Date());
            }

            //We throw an unchecked exception since we don't expect the caller to handle it (we do not want to deal with wrong inputs in this exercise)
            throw new IllegalArgumentException("Unable to parse input : " + userInput);
        }
    }
}
