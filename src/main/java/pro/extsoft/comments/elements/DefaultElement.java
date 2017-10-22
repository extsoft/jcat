package pro.extsoft.comments.elements;

import org.openqa.selenium.*;

import java.util.List;

public class DefaultElement implements Element {

    private final ObjectWrapper objectWrapper;

    public DefaultElement(Element parent, By childSelector) {
        this(new ParentAndChild(parent, childSelector));
    }

    public DefaultElement(WebDriver webDriver, By selector) {
        this(new DriverAndLocator(webDriver, selector));
    }

    public DefaultElement(WebElement webElement) {
        this(new SeleniumElement(webElement));
    }

    private DefaultElement(ObjectWrapper objectWrapper) {
        this.objectWrapper = objectWrapper;
    }

    @Override
    public void click() {
        objectWrapper.element().click();
    }

    @Override
    public void submit() {
        objectWrapper.element().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        objectWrapper.element().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        objectWrapper.element().clear();
    }

    @Override
    public String getTagName() {
        return objectWrapper.element().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return objectWrapper.element().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return objectWrapper.element().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return objectWrapper.element().isEnabled();
    }

    @Override
    public String getText() {
        return objectWrapper.element().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return objectWrapper.element().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return objectWrapper.element().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return objectWrapper.element().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return objectWrapper.element().getLocation();
    }

    @Override
    public Dimension getSize() {
        return objectWrapper.element().getSize();
    }

    @Override
    public Rectangle getRect() {
        return objectWrapper.element().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return objectWrapper.element().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return objectWrapper.element().getScreenshotAs(outputType);
    }

    private interface ObjectWrapper {
        WebElement element();
    }

    private final static class DriverAndLocator implements ObjectWrapper {

        private final WebDriver webDriver;
        private final By by;

        private DriverAndLocator(WebDriver webDriver, By by) {
            this.webDriver = webDriver;
            this.by = by;
        }

        @Override
        public WebElement element() {
            return webDriver.findElement(by);
        }
    }

    private final static class ParentAndChild implements ObjectWrapper {

        private final WebElement webElement;
        private final By childLocator;

        private ParentAndChild(WebElement webElement, By childLocator) {
            this.webElement = webElement;
            this.childLocator = childLocator;
        }

        @Override
        public WebElement element() {
            return webElement.findElement(childLocator);
        }
    }

    private final static class SeleniumElement implements ObjectWrapper {

        private final WebElement webElement;

        private SeleniumElement(WebElement webElement) {
            this.webElement = webElement;
        }

        @Override
        public WebElement element() {
            return webElement;
        }
    }
}
