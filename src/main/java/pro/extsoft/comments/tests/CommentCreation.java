package pro.extsoft.comments.tests;

import org.testng.annotations.Test;
import pro.extsoft.comments.Base;
import pro.extsoft.comments.MainScreen;
import pro.extsoft.comments.RealMainScreen;
import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comment.DefaultComment;
import pro.extsoft.comments.comment.SaveAndReturnComment;
import pro.extsoft.comments.comments.Comments;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1.0
 */
public class CommentCreation extends Base {
    @Test
    public void testCommentCreation() throws IOException {
        MainScreen mainScreen = new RealMainScreen(this.driver,this.baseURL);
        mainScreen.open();
        Comments comments = mainScreen.comments("1");
        Comment comment = new SaveAndReturnComment(
                this.driver, new DefaultComment(this.driver, "dd45", "45", false)
        );
        comments.create(comment);
        assert mainScreen.contains(comment);
    }
}
