package pro.extsoft.comments.tests;

import org.testng.annotations.Test;
import pro.extsoft.comments.Base;
import pro.extsoft.comments.MainScreen;
import pro.extsoft.comments.RealMainScreen;
import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comment.DefaultComment;
import pro.extsoft.comments.comment.SaveAndReturnComment;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1.0
 */
public class CommentDeletion extends Base {
    @Test
    public void testCommentDeletion() {
        MainScreen mainScreen = new RealMainScreen(this.browser());
        mainScreen.open();
        Comment comment = new SaveAndReturnComment(
                this.browser(), new DefaultComment(this.browser(), "dd47", "47", false)
        );
        mainScreen.lastComments().create(comment);
        mainScreen.lastComments().delete(comment);
        assert !mainScreen.contains(comment);
    }
}
