package com.extsoft.comments.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultField implements Field {

    private final Element element;

    public DefaultField(WebDriver webDriver, By selector) {
        this(new DefaultElement(webDriver, selector));
    }

    public DefaultField(Element element) {
        this.element = element;
    }


    @Override
    public void save(String data) {
        WebElement element = this.element;
        element.clear();
        element.sendKeys(data);
    }

    @Override
    public String data() {
        return element.getText();
    }
}
