package com.hatanian.twitter.command.viewtimeline;

import com.google.inject.Inject;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;

public class ViewTimelineCommandFactory {

    private PostRepository postRepository;
    private Output output;
    private PostFormatter postFormatter;

    @Inject
    public ViewTimelineCommandFactory(PostRepository postRepository, Output output, PostFormatter postFormatter) {
        this.postRepository = postRepository;
        this.output = output;
        this.postFormatter = postFormatter;
    }

    public ViewTimelineCommand createViewTimelineCommand(String user) {
        return new ViewTimelineCommand(postRepository, new User(user), output, postFormatter);
    }
}
