package com.extsoft.comments.comments;

import com.extsoft.comments.elements.AllElements;
import com.extsoft.comments.elements.DefaultElements;
import com.extsoft.comments.elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

final class Rows {
    private final WebDriver webDriver;
    private final By by;

    Rows(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.by = by;
    }

    Iterator<Row> rows() {
        Iterator<Element> iterator = new DefaultElements(webDriver, by).find(new AllElements());
        return new Iterator<Row>() {

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Row next() {
                return new Row(webDriver, iterator.next());
            }
        };
    }
}
