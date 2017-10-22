package pro.extsoft.comments.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultElements implements Elements {

    private final WebDriver webDriver;
    private final By elementsLocator;

    public DefaultElements(WebDriver webDriver, By elementsLocator) {
        this.webDriver = webDriver;
        this.elementsLocator = elementsLocator;
    }

    @Override
    public Iterator<Element> find(Criteria criteria) {
        return instances().stream().filter(criteria::relevant).collect(Collectors.toList()).iterator();
    }

    private List<Element> instances() {
        return webDriver.findElements(elementsLocator)
                .stream()
                .map(DefaultElement::new)
                .collect(Collectors.toList());
    }
}
