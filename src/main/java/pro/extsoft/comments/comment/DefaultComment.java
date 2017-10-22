package pro.extsoft.comments.comment;

import pro.extsoft.comments.comments.Row;
import pro.extsoft.comments.comments.Rows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pro.extsoft.comments.elements.*;

import java.util.Iterator;

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
    public void select() {
        Iterator<Row> iterator = new Rows(webDriver, By.xpath("//*/tbody/*")).rows();
        while (iterator.hasNext()) {
            Element element = iterator.next().element();
            String currentId = new DefaultElement(element, By.cssSelector(".numbercolumn")).getText();
            if (currentId.equals(number)) {
                new SmartCheckBox(new DefaultCheckBox(new DefaultElement(element, By.cssSelector(".checkedcolumn"))))
                        .check();
            }
        }
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
