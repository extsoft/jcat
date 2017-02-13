package com.extsoft.comments.comments;

import com.extsoft.comments.elements.DefaultElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Rows {
    private final WebDriver webDriver;
    private final By by;

    Rows(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.by = by;
    }

    Iterator<Row> rows() {
        List<Row> rows = new ArrayList<>();
        new DefaultElements(webDriver, by)
                .instances()
                .forEachRemaining(element -> rows.add(new Row(webDriver, element)));
        return rows.iterator();
    }
}
