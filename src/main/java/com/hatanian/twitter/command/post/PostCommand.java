package com.hatanian.twitter.command.post;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.command.persistence.PostRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PostCommand implements Command {
    private PostRepository postRepository;
    private final User user;
    private final PostContent postContent;

    public PostCommand(PostRepository postRepository, User user, PostContent postContent) {
        this.postRepository = postRepository;
        this.user = user;
        this.postContent = postContent;
    }

    @Override
    public void run() {
        postRepository.savePost(new Post(user, postContent));
    }
}
