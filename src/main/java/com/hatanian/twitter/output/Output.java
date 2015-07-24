package com.hatanian.twitter.output;

import com.hatanian.twitter.domain.Post;

import java.io.PrintStream;
import java.util.stream.Stream;

public class Output {
    private PrintStream printStream;
    private PostFormatter postFormatter;

    public Output(PrintStream printStream, PostFormatter postFormatter) {
        this.printStream = printStream;
        this.postFormatter = postFormatter;
    }

    public void printPosts(Stream<Post> posts) {
        posts.forEachOrdered(post -> printStream.println(postFormatter.formatPost(post)));
    }
}
