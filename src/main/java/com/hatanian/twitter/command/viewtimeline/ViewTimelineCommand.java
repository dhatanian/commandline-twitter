package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ViewTimelineCommand implements Command {
    private final PostsRepository postsRepository;
    private final User user;
    private Output output;
    private PostFormatter postFormatter;

    public ViewTimelineCommand(PostsRepository postsRepository, User user, Output output, PostFormatter postFormatter) {
        this.postsRepository = postsRepository;
        this.user = user;
        this.output = output;
        this.postFormatter = postFormatter;
    }

    @Override
    public void run() {
        postsRepository.getUserTimeline(user).map(postFormatter::format).forEach(output::println);
    }
}
