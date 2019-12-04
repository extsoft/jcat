package pro.extsoft.comments.tests;

import org.testng.annotations.Test;
import pro.extsoft.comments.Base;
import pro.extsoft.comments.MainScreen;
import pro.extsoft.comments.RealMainScreen;
import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comment.DefaultComment;
import pro.extsoft.comments.comment.SaveAndReturnComment;

import java.io.IOException;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1.0
 */
public class CommentDuplication extends Base {
    @Test
    public void testCommentDuplication() throws IOException {
        MainScreen mainScreen = new RealMainScreen(this.driver,this.baseURL);
        mainScreen.open();
        Comment comment = new SaveAndReturnComment(
                this.driver, new DefaultComment(this.driver, "dd46", "46", false)
        );
        mainScreen.comments("1").create(comment);
        Comment duplicate = new SaveAndReturnComment(
                this.driver, new DefaultComment(this.driver, "duplicate", "48", false)
        );
        mainScreen.lastComments().duplicate(comment, duplicate);
        assert mainScreen.contains(duplicate);
    }
}
