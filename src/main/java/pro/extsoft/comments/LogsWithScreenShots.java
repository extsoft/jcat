package pro.extsoft.comments;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogsWithScreenShots
{
    private WebDriver driver = null;
    public LogsWithScreenShots(WebDriver _driver)
    {
        driver = _driver;
    }
    public  void addlog(String text) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hh_mm_ss");

        String  path = "test-output/img/";
        File file = new File(path);
        File screenshot =  ((TakesScreenshot) (this.driver)).getScreenshotAs(OutputType.FILE);
        Calendar now = Calendar.getInstance();
        String nameFile = formatter.format(now.getTime()) +".jpg";
        String nameInmg = file.getAbsolutePath() + formatter.format(now.getTime()) +".jpg";
        FileUtils.copyFile(screenshot, new File(file.getAbsolutePath() + formatter.format(now.getTime()) +".jpg"));
       // this.log("<img src="+nameInmg+"'>");
        System.out.print(text+ "<img src="+file.getAbsolutePath() + formatter.format(now.getTime()) +".jpg"+">");
        Reporter.log(text+ "<img src="+file.getAbsolutePath() + formatter.format(now.getTime()) +".jpg"+">");
    }
}
