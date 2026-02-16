package testBase;

import Listeners.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;

public class BaseClass {
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static Logger log;



    @BeforeMethod
    public void setUp(){
        log= LogManager.getLogger(this.getClass());
        log.info("====Test Suite Started====");

        driver= DriverFactory.initDriver();
        log.info("Browser launched");

        extent=ExtentReportManager.getReportInstance();
        log.info("Extent report initialized");
    }

    @AfterMethod
    public void tearDown() {
        log.info("====Test Suite Ended====");
        extent.flush();

        if(driver!=null){
            driver.quit();
        }
    }
}
