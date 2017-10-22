package pro.extsoft.comments.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultButton implements Button {

    private final Element element;

    public DefaultButton(WebDriver webDriver, By selector) {
        this(new DefaultElement(webDriver, selector));
    }

    public DefaultButton(Element element) {
        this.element = element;
    }


    @Override
    public void press() {
        element.click();
    }

    @Override
    public boolean enabled() {
        return element.isEnabled();
    }

    @Override
    public String name() {
        return element.getText();
    }
}
