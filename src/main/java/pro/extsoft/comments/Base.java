package pro.extsoft.comments;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Base {

    private final WebDriver[] browsers = new WebDriver[1];
    private final Map<String, Capabilities> options;

    protected Base() {
        this.options = new HashMap<>();
        this.options.put("firefox", new FirefoxOptions());
        this.options.put("chrome", new ChromeOptions());
    }

    protected final WebDriver browser() {
        return browsers[0];
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        final WebDriver driver = new RemoteWebDriver(
                new URL(System.getProperty("selenium-url", "http://localhost:9515")),
                this.options.get(System.getProperty("browser", "chrome").toLowerCase())
        );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browsers[0] = driver;
    }

    @AfterTest
    public void tearDown() {
        this.browser().quit();
    }
}
