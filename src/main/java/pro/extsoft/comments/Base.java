package pro.extsoft.comments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class Base {

    private final WebDriver[] browsers = new WebDriver[1];
    ArrayList<String> resutltList = new ArrayList<String>();
    protected WebDriver driver = null;
    protected  String baseURL;
    protected  String pathToconfiguration;
    private static String log ="";




    @Parameters({"currentBrowser","testProperty"})
    @BeforeClass()
    public  void setUp(String currentBrowser, String testProperty) throws IOException {
        Config config = new Config();
        resutltList = config.getrestProperty("base.url",testProperty);
        baseURL = resutltList.get(0);
        pathToconfiguration = resutltList.get(1);
        if(currentBrowser.equals("chrome"))
        {
            String  path = "drivers\\chromedriver-windows-64bit.exe";
            File file = new File(path);
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
        //TODO: add ability launch with firefox
    }

    @AfterClass
    public void tearDown() throws Exception {
        // Allure.addAttachment(
        //      "before-quit", "image/png",
        //        new ByteArrayInputStream(((TakesScreenshot) this.browser()).getScreenshotAs(OutputType.BYTES)),
        //         ".png"
        //  );

        this.driver.close();
    }


}
