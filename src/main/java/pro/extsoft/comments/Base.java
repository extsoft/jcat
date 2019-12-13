package pro.extsoft.comments;

import io.qameta.allure.Allure;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
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
                new URL(System.getProperty("selenium-url", "http://192.168.56.1:4444/wd/hub")),
                this.options.get(System.getProperty("browser", "chrome").toLowerCase())
        );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browsers[0] = driver;
    }

    @AfterTest
    public void tearDown() {
        Allure.addAttachment(
                "before-quit", "image/png",
                new ByteArrayInputStream(((TakesScreenshot) this.browser()).getScreenshotAs(OutputType.BYTES)),
                ".png"
        );
        this.browser().quit();
    }
}
