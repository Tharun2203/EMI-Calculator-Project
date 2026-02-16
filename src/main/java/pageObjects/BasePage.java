package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;



    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        this.actions=new Actions(driver);
        this.js=(JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }

    protected void  type(WebElement element, String value){
        element.click();
        element.sendKeys(Keys.CONTROL+"a");
        element.sendKeys(Keys.DELETE);
       //element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }
    protected void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void hardWait(int seconds){
        try {
            Thread.sleep(seconds*2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
