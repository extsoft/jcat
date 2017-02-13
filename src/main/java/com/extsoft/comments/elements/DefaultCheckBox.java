package com.extsoft.comments.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultCheckBox implements CheckBox {

    private final Element element;

    public DefaultCheckBox(WebDriver webDriver, By selector) {
        this(new DefaultElement(webDriver, selector));
    }

    public DefaultCheckBox(Element element) {
        this.element = element;
    }

    @Override
    public void check() {
        element.click();
    }

    @Override
    public void uncheck() {
        element.click();
    }

    @Override
    public boolean checked() {
        return element.isSelected();
    }
}
