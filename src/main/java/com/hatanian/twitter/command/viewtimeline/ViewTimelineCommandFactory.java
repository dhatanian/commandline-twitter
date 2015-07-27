package com.hatanian.twitter.command.viewtimeline;

import com.google.inject.Inject;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;

public class ViewTimelineCommandFactory {

    private PostsRepository postsRepository;
    private Output output;
    private PostFormatter postFormatter;

    @Inject
    public ViewTimelineCommandFactory(PostsRepository postsRepository, Output output, PostFormatter postFormatter) {
        this.postsRepository = postsRepository;
        this.output = output;
        this.postFormatter = postFormatter;
    }

    public ViewTimelineCommand createViewTimelineCommand(String user) {
        return new ViewTimelineCommand(postsRepository, new User(user), output, postFormatter);
    }
}
