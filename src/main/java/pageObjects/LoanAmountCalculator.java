package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoanAmountCalculator extends BasePage {

    public LoanAmountCalculator(WebDriver driver){
        super(driver);
    }



    @FindBy(xpath="//a[@id='menu-item-dropdown-2696']")
    private WebElement loanCalculatorzMenu;

    @FindBy(xpath="//a[@title='Loan Calculator']")
    private WebElement loanCalculatorOption;

    @FindBy(xpath="//li[@id='loan-amount-calc']")
    private WebElement loanCalTab;

    @FindBy(xpath="//input[@id='loanemi']")
    private WebElement loanEmi;

    @FindBy(xpath="//input[@id='loaninterest']")
    private WebElement interesRate;

    @FindBy(xpath="//input[@id='loanterm']")
    private WebElement loanTenure;

    @FindBy(xpath="//input[@id='loanfees']")
    private WebElement fees;

    @FindBy(xpath="//div[@id='loanemislider']/span")
    private WebElement emiAmtSlider;

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

    public void openLoanCalculator(){
        wait.until(ExpectedConditions.elementToBeClickable(loanCalTab)).click();
    }

    private void validateSliderText(WebElement slider, WebElement textbox){
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
        validateSliderText(emiAmtSlider,loanEmi);
    }

    public void validateInterestRate(){
        validateSliderText(loanIntSlider,interesRate);
    }

    public void validateTenure(){
        validateSliderText(loanTermSlider,loanTenure);
    }

    public void validateFee(){
        validateSliderText(loanFeeSlider,fees);
    }

}
