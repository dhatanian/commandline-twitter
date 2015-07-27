package com.hatanian.twitter.command.post;

import com.google.inject.Inject;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;

public class PostCommandFactory {
    private PostRepository postRepository;

    @Inject
    public PostCommandFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostCommand createPostCommand(String user, String content) {
        return new PostCommand(postRepository, new User(user), new PostContent(content));
    }
}
