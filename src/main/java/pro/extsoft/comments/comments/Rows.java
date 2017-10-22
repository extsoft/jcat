package pro.extsoft.comments.comments;

import pro.extsoft.comments.elements.AllElements;
import pro.extsoft.comments.elements.DefaultElements;
import pro.extsoft.comments.elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public final class Rows {
    private final WebDriver webDriver;
    private final By by;

    public Rows(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.by = by;
    }

    public Iterator<Row> rows() {
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
