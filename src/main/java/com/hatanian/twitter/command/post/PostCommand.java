package com.hatanian.twitter.command.post;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PostCommand implements Command {
    private User user;
    private PostContent postContent;
    private PostRepository postRepository;

    protected PostCommand(User user, PostContent postContent, PostRepository postRepository) {
        this.user = user;
        this.postContent = postContent;
        this.postRepository = postRepository;
    }

    @Override
    public void run() {
        postRepository.save(new Post(user, postContent));
    }
}
