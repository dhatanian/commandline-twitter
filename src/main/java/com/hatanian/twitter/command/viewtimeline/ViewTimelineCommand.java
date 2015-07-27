package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ViewTimelineCommand implements Command {
    private final PostRepository postRepository;
    private final User user;
    private Output output;
    private PostFormatter postFormatter;

    public ViewTimelineCommand(PostRepository postRepository, User user, Output output, PostFormatter postFormatter) {
        this.postRepository = postRepository;
        this.user = user;
        this.output = output;
        this.postFormatter = postFormatter;
    }

    @Override
    public void run() {
        postRepository.getUserTimeline(user).map(postFormatter::format).forEach(output::println);
    }
}
