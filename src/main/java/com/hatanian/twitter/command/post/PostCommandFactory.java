package com.hatanian.twitter.command.post;

import com.google.inject.Inject;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;

public class PostCommandFactory {
    private PostRepository postRepository;

    @Inject
    public PostCommandFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostCommand buildPostCommand(User user, PostContent postContent) {
        return new PostCommand(user, postContent, postRepository);
    }
}
