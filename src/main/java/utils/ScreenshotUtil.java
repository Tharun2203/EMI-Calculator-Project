package utils;

import freemarker.template.SimpleDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String baseName){
        String timestamp= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName=baseName+"_"+timestamp+".png";
        String filePath="screenshots/"+fileName;
        try{
            TakesScreenshot ts=(TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            File dest=new File(filePath);
           Files.copy(src.toPath(),dest.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static String getScreenshot(WebDriver driver){
        return((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
