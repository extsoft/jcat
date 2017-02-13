package com.extsoft.comments;

import com.extsoft.comments.comment.Comment;
import com.extsoft.comments.comment.DefaultComment;
import com.extsoft.comments.comment.SaveAndReturnComment;
import com.extsoft.comments.comments.Comments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AutomatedTests {

    private WebDriver driver;

    @Test
    public void testCommentCreation() {
        MainScreen mainScreen = new RealMainScreen(driver);
        mainScreen.open();
        Comments comments = mainScreen.comments("1");
        Comment comment = new SaveAndReturnComment(driver, new DefaultComment(driver, "dd45", "45", false));
        comments.create(comment);
        assert mainScreen.contains(comment);
    }


    @Test
    public void testCommentDuplication() {
        MainScreen mainScreen = new RealMainScreen(driver);
        mainScreen.open();
        Comment comment = new SaveAndReturnComment(driver, new DefaultComment(driver, "dd46", "46", false));
        mainScreen.comments("1").create(comment);
        Comment duplicate = new SaveAndReturnComment(driver, new DefaultComment(driver, "duplicate", "48", false));
        mainScreen.lastComments().duplicate(comment, duplicate);
        assert mainScreen.contains(duplicate);
    }


    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
