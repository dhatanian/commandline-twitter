package com.hatanian.twitter.domain;

public class Post {
    private User user;
    private PostContent content;

    public Post(User user, PostContent content) {
        this.user = user;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (user != null ? !user.equals(post.user) : post.user != null) return false;
        return !(content != null ? !content.equals(post.content) : post.content != null);

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
