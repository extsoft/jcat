package com.extsoft.comments.comments;

import com.extsoft.comments.comment.Comment;
import com.extsoft.comments.comment.DefaultComment;
import com.extsoft.comments.elements.DefaultElement;
import com.extsoft.comments.elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

final class Row {
    private final WebDriver webDriver;
    private final Element element;

    Row(WebDriver webDriver, Element element) {
        this.webDriver = webDriver;
        this.element = element;
    }

    Element element() {
        return element;
    }

    Comment comment() {
        return new DefaultComment(
                webDriver,
                new DefaultElement(element, By.cssSelector(".textcolumn")).getText(),
                new DefaultElement(element, By.cssSelector(".numbercolumn")).getText(),
                !new DefaultElement(element, By.cssSelector(".inactivecolumn")).getText().contains("V")
        );
    }
}
