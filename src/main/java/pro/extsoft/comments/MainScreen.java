package pro.extsoft.comments;

import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comments.Comments;

import java.util.Iterator;

public interface MainScreen {

    void open();

    Iterator<String> commentsPageNames();

    Comments comments(String pageName);

    Comments lastComments();

    boolean contains(Comment comment);
}
