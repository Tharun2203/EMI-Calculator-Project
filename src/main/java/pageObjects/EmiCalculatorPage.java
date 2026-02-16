package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmiCalculatorPage extends BasePage{

    public EmiCalculatorPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[@id='menu-item-dropdown-2696']")
    private WebElement loanCalculatorzMenu;

    @FindBy(xpath="//a[@title='Loan Calculator']")
    private WebElement loanCalculatorOption;

    @FindBy(xpath="//li[@id='emi-calc']")
    private WebElement emiCalTab;

    @FindBy(xpath="//input[@id='loanamount']")
    private WebElement loanAmt;

    @FindBy(xpath="//input[@id='loaninterest']")
    private WebElement interesRate;

    @FindBy(xpath="//input[@id='loanterm']")
    private WebElement loanTenure;

    @FindBy(xpath="//input[@id='loanfees']")
    private WebElement fees;

    @FindBy(xpath="//div[@id='loanamountslider']/span")
    private WebElement loanAmtSlider;

    @FindBy(xpath="//div[@id='loaninterestslider']/span")
    private WebElement loanIntSlider;

    @FindBy(xpath="//div[@id='loantermslider']/span")
    private WebElement loanTermSlider;

    @FindBy(xpath="//div[@id='loanfeesslider']/span")
    private WebElement loanFeeSlider;


    public void openLoanCalculatorMenu(){
        loanCalculatorzMenu.click();
        loanCalculatorOption.click();
    }


    public void openEmiCalculator(){
        wait.until(ExpectedConditions.elementToBeClickable(emiCalTab)).click();
    }

    private void validateSliderAndTextbox(WebElement slider, WebElement textbox){
        String before=textbox.getAttribute("value");

        actions.dragAndDropBy(slider,60,0).perform();


        try{
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String after=textbox.getAttribute("value");

        Assert.assertNotEquals(before,after,"TextBox value did NOT change after sliding");
    }

    public void validateLoanAmount(){
        openLoanCalculatorMenu();
        openEmiCalculator();
        validateSliderAndTextbox(loanAmtSlider,loanAmt);
    }

    public void validateLoanInterest(){

        validateSliderAndTextbox(loanIntSlider,interesRate);
    }

    public void validateLoanTenure(){

        validateSliderAndTextbox(loanTermSlider,loanTenure);
    }

    public void validateLoanFee(){
        validateSliderAndTextbox(loanFeeSlider,fees);
    }

}
