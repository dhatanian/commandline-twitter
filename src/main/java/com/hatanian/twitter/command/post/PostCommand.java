package com.hatanian.twitter.command.post;

import com.hatanian.twitter.command.Command;
import com.hatanian.twitter.domain.Post;
import com.hatanian.twitter.domain.PostContent;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommand that = (PostCommand) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (postContent != null ? !postContent.equals(that.postContent) : that.postContent != null) return false;
        return !(postRepository != null ? !postRepository.equals(that.postRepository) : that.postRepository != null);

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (postContent != null ? postContent.hashCode() : 0);
        result = 31 * result + (postRepository != null ? postRepository.hashCode() : 0);
        return result;
    }
}
