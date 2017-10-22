package pro.extsoft.comments.comments;

import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.elements.DefaultButton;
import pro.extsoft.comments.elements.DefaultCheckBox;
import pro.extsoft.comments.elements.DefaultElement;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public class RealComments implements Comments {

    final WebDriver webDriver;
    private final Rows rows;

    public RealComments(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.rows = new Rows(webDriver, By.xpath("//*/tbody/*"));
    }

    @Override
    public void create(Comment comment) {
        new DefaultButton(webDriver, By.id("newbutton")).press();
        comment.fillData();
        comment.save();
    }

    @Override
    public void duplicate(Comment original, Comment duplicate) {
        Iterator<Row> rows = this.rows.rows();
        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.comment().equals(original)) {
                new DefaultCheckBox(new DefaultElement(row.element(), By.name("SelectedId"))).check();
                new DefaultButton(webDriver, By.cssSelector("input[value='Duplicate...']")).press();
                duplicate.fillData();
                duplicate.save();
                return;
            }
        }
        throw new RuntimeException("Unable to duplicate comment: " + original.info());
    }

    @Override
    public void edit(Comment original, Comment changes) {
//        new DefaultButton(webDriver, By.cssSelector("input[value='Edit..']")).press();
        throw new NotImplementedException("IMPL");
    }

    @Override
    public void delete(Comment comment) {
        comment.select();
        new DefaultButton(webDriver, By.cssSelector("input[value='Delete']")).press();
        new DefaultButton(webDriver, By.cssSelector(".ui-button:first-child")).press();
    }

    @Override
    public boolean contains(Comment comment) {
        Iterator<Row> rows = this.rows.rows();
        while (rows.hasNext()) {
            Row row = rows.next();
            if (row.comment().equals(comment)) return true;
        }
        return false;
    }
}
