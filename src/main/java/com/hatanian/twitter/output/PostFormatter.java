package com.hatanian.twitter.output;

import com.google.inject.Inject;
import com.hatanian.twitter.domain.Post;

public class PostFormatter {

    private TimeFormatter timeFormatter;

    @Inject
    public PostFormatter(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
    }

    public String formatPost(Post post) {
        return post.getContent().getValue() + " (" + timeFormatter.formatDateAsTimePastSince(post.getCreationDate()) + ")";
    }

}
