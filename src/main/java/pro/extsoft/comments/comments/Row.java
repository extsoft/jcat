package pro.extsoft.comments.comments;

import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comment.DefaultComment;
import pro.extsoft.comments.elements.DefaultElement;
import pro.extsoft.comments.elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class Row {
    private final WebDriver webDriver;
    private final Element element;

    public Row(WebDriver webDriver, Element element) {
        this.webDriver = webDriver;
        this.element = element;
    }

    public Element element() {
        return element;
    }

    public Comment comment() {
        return new DefaultComment(
                webDriver,
                new DefaultElement(element, By.cssSelector(".textcolumn")).getText(),
                new DefaultElement(element, By.cssSelector(".numbercolumn")).getText(),
                !new DefaultElement(element, By.cssSelector(".inactivecolumn")).getText().contains("V")
        );
    }
}
