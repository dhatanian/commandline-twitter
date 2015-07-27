package com.hatanian.twitter.command.post;

import com.google.inject.Inject;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;

public class PostCommandFactory {
    private PostsRepository postsRepository;

    @Inject
    public PostCommandFactory(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public PostCommand createPostCommand(String user, String content) {
        return new PostCommand(postsRepository, new User(user), new PostContent(content));
    }
}
