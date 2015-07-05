# Command Line Twitter
A twitter ersatz in command line

## To use this application ##
This is a Maven project. You can run it in an IDE (tested on IntelliJ IDEA) by running the `com.hatanian.twitter.App.main()` method.

You can also package it in a stand-alone jar with the `mvn clean package` command. In this case you will find a runnable jar in the `target` directory :

    java -jar target/commandline-twitter-1.0-SNAPSHOT-jar-with-dependencies.jar 

Use the exit` command to, well, exit the program. 


## Requirements and limitations ##
 * User names cannot contain spaces
 * User names cannot be "exit"
 * Execution and compilation requires Java 8
