package com.hatanian.twitter.command.viewtimeline;

import com.google.inject.Inject;
import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;

public class ViewTimelineCommandFactory {
    private PostRepository postRepository;
    private Output output;

    @Inject
    public ViewTimelineCommandFactory(PostRepository postRepository, Output output) {
        this.postRepository = postRepository;
        this.output = output;
    }

    public ViewTimelineCommand buildViewTimelineCommand(User user) {
        return new ViewTimelineCommand(postRepository, user, output);
    }
}
