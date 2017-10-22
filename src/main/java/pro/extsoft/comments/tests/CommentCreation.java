package pro.extsoft.comments.tests;

import org.testng.annotations.Test;
import pro.extsoft.comments.MainScreen;
import pro.extsoft.comments.RealMainScreen;
import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comment.DefaultComment;
import pro.extsoft.comments.comment.SaveAndReturnComment;
import pro.extsoft.comments.comments.Comments;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1.0
 */
public class CommentCreation extends Base {
    @Test
    public void testCommentCreation() {
        MainScreen mainScreen = new RealMainScreen(driver);
        mainScreen.open();
        Comments comments = mainScreen.comments("1");
        Comment comment = new SaveAndReturnComment(
                driver, new DefaultComment(driver, "dd45", "45", false)
        );
        comments.create(comment);
        assert mainScreen.contains(comment);
    }
}
