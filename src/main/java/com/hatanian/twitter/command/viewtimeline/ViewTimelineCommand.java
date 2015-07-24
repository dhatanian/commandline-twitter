package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ViewTimelineCommand implements Command {
    private PostRepository postRepository;
    private User user;
    private Output output;

    public ViewTimelineCommand(PostRepository postRepository, User user, Output output) {
        this.postRepository = postRepository;
        this.user = user;
        this.output = output;
    }

    @Override
    public void run() {
        output.printPosts(postRepository.getUserTimeline(user));
    }
}
