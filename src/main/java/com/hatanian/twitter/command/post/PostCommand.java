package com.hatanian.twitter.command.post;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.persistence.PostsRepository;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class PostCommand implements Command {
    private PostsRepository postsRepository;
    private final User user;
    private final PostContent postContent;

    public PostCommand(PostsRepository postsRepository, User user, PostContent postContent) {
        this.postsRepository = postsRepository;
        this.user = user;
        this.postContent = postContent;
    }

    @Override
    public void run() {
        postsRepository.savePost(new Post(user, postContent));
    }
}
