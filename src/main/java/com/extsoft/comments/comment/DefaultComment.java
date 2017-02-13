package com.extsoft.comments.comment;

import com.extsoft.comments.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultComment implements Comment {

    private final WebDriver webDriver;
    private final Field textField;
    private final Field numberField;
    private final CheckBox activeChekBox;
    private final Button saveComment;
    private final Button allCategories;
    private final String text;
    private final String number;
    private final Boolean active;

    public DefaultComment(WebDriver webDriver, String text, String number, Boolean active) {
        this.webDriver = webDriver;
        textField = new DefaultField(webDriver, By.id("Text"));
        numberField = new DefaultField(webDriver, By.id("Number"));
        activeChekBox = new SmartCheckBox(new DefaultCheckBox(webDriver, By.id("Active")));
        saveComment = new DefaultButton(webDriver, By.cssSelector("input[value='Save']"));
        allCategories = new DefaultButton(webDriver, By.name("AllSelect"));
        this.text = text;
        this.number = number;
        this.active = active;
    }

    @Override
    public Comment pageComment() {
        return new DefaultComment(
                webDriver,
                textField.data(),
                numberField.data(),
                activeChekBox.checked()
        );
    }

    @Override
    public void fillData() {
        textField.save(text);
        numberField.save(number);
        if (active) {
            activeChekBox.check();
        } else {
            activeChekBox.uncheck();
        }
        allCategories.press();
    }

    @Override
    public void save() {
        saveComment.press();
    }

    @Override
    public String info() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", number='" + number + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        try {
            Comment that = (Comment) o;
            return this.info().equals(that.info());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + active.hashCode();
        return result;
    }
}
