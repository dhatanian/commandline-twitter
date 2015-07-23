package com.hatanian.twitter.domain;

public class PostContent {
    private String content;

    public PostContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostContent that = (PostContent) o;

        return !(content != null ? !content.equals(that.content) : that.content != null);

    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
