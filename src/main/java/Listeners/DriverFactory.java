package Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {
    public static WebDriver driver;

    private static final Logger log= LogManager.getLogger(DriverFactory.class);

    public static WebDriver initDriver(){
        log.info("Initializing Chrome Driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log.info("Navigating to EMI Calculator Website");
        driver.get("https://emicalculator.net/");
        return driver;

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
