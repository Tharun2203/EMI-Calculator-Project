package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import testBase.BaseClass;

public class LoanTenureCalculator extends BasePage {

    public LoanTenureCalculator(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[@id='menu-item-dropdown-2696']")
    private WebElement loanCalculatorzMenu;

    @FindBy(xpath="//a[@title='Loan Calculator']")
    private WebElement loanCalculatorOption;

    @FindBy(xpath="//li[@id='loan-tenure-calc']")
    private WebElement loanTenureTab;

    @FindBy(xpath="//input[@id='loanamount']")
    private WebElement loanAmt;

    @FindBy(xpath="//input[@id='loanemi']")
    private WebElement emi;

    @FindBy(xpath="//input[@id='loanterm']")
    private WebElement interesRate;

    @FindBy(xpath="//input[@id='loanfees']")
    private WebElement fees;

    @FindBy(xpath="//div[@id='loanamountslider']/span")
    private WebElement loanAmtSlider;

    @FindBy(xpath="//div[@id='loanemislider']/span")
    private WebElement emiSlider;

    @FindBy(xpath="//div[@id='loaninterestslider']/span")
    private WebElement loanIntSlider;

    @FindBy(xpath="//div[@id='loanfeesslider']/span")
    private WebElement feeSlider;


    public void openLoanCalculatorMenu(){
        loanCalculatorzMenu.click();
        loanCalculatorOption.click();
    }

    public void openLoanCalculator(){
        wait.until(ExpectedConditions.elementToBeClickable(loanTenureTab)).click();
    }

    private void validateSlidersAndText(WebElement slider, WebElement textbox){
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

    public void validateLoanEmi(){
        openLoanCalculatorMenu();
        openLoanCalculator();
        validateSlidersAndText(loanAmtSlider,loanAmt);
    }

    public void validateInterestRate(){
        validateSlidersAndText(emiSlider,emi);
    }

    public void validateTenure(){
        validateSlidersAndText(loanIntSlider,interesRate);
    }

    public void validateFee(){
        validateSlidersAndText(feeSlider,fees);
    }

}
