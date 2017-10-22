package pro.extsoft.comments.comments;

import pro.extsoft.comments.comment.Comment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pro.extsoft.comments.elements.*;

import java.util.Iterator;

public class SelfLoadedComments implements Comments {

    private final WebDriver webDriver;
    private final String page;
    private final Comments comments;

    public SelfLoadedComments(WebDriver webDriver, String page) {
        this.webDriver = webDriver;
        this.page = page;
        this.comments = new RealComments(webDriver);
    }

    private void switchPage() {
        Elements elements = new DefaultElements(webDriver, By.cssSelector(".webgrid-footer a"));
        Iterator<Element> iterator = elements.find(new ContainsText(page));
        if (iterator.hasNext()) {
            new DefaultButton(iterator.next()).press();
        }
    }

    @Override
    public void create(Comment comment) {
        switchPage();
        comments.create(comment);
    }

    @Override
    public void duplicate(Comment original, Comment duplicate) {
        switchPage();
        comments.duplicate(original, duplicate);
    }

    @Override
    public void edit(Comment original, Comment changes) {
        switchPage();
        comments.edit(original, changes);
    }

    @Override
    public void delete(Comment comment) {
        switchPage();
        comments.delete(comment);
    }

    @Override
    public boolean contains(Comment comment) {
        switchPage();
        return comments.contains(comment);
    }
}
