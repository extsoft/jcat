package com.extsoft.comments.comment;

import com.extsoft.comments.elements.DefaultButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveAndReturnComment implements Comment {

    private final WebDriver webDriver;
    private final Comment comment;

    public SaveAndReturnComment(WebDriver webDriver, Comment comment) {
        this.webDriver = webDriver;
        this.comment = comment;
    }

    @Override
    public Comment pageComment() {
        return comment.pageComment();
    }

    @Override
    public void fillData() {
        comment.fillData();
    }

    @Override
    public void save() {
        new DefaultButton(webDriver, By.cssSelector("input[value='Save & Return']")).press();
    }

    @Override
    public String info() {
        return comment.info();
    }

    @Override
    public void select() {
        comment.select();
    }
}
