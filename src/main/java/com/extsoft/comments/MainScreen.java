package com.extsoft.comments;

import com.extsoft.comments.comment.Comment;
import com.extsoft.comments.comments.Comments;

import java.util.Iterator;

public interface MainScreen {

    void open();

    Iterator<String> commentsPageNames();

    Comments comments(String pageName);

    Comments lastComments();

    boolean contains(Comment comment);
}
