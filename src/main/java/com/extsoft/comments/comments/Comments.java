package com.extsoft.comments.comments;

import com.extsoft.comments.comment.Comment;

public interface Comments {

    void create(Comment comment);

    void duplicate(Comment original, Comment duplicate);

    void edit(Comment original, Comment changes);

    void delete(Comment comment);

    boolean contains(Comment comment);
}
