package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarLoanPage extends BasePage{

    public CarLoanPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[text()='Car Loan']")
    WebElement carLoanTab;

    @FindBy(xpath="//input[@id='loanamount']")
    WebElement loanAmount;

    @FindBy(xpath="//input[@id='loaninterest']")
    WebElement interest;

    @FindBy(xpath="//input[@id='loanterm']")
    WebElement tenure;


    @FindBy(xpath="//h4[text()='Loan EMI']/following-sibling::p")
    WebElement loanEmi;

    @FindBy(xpath="//h4[text()='Total Interest Payable']/following-sibling::p")
    WebElement totalInterest;

    @FindBy(xpath="//h4[text()='Total Payment']/following-sibling::p")
    WebElement totalAmount;




    public void selectCarLoan(){
        wait.until(ExpectedConditions.elementToBeClickable(carLoanTab));
        carLoanTab.click();
        wait.until(ExpectedConditions.visibilityOf(loanAmount));
    }


    public void enterCarLoanDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(loanAmount));
        type(loanAmount,"1500000");

        wait.until(ExpectedConditions.elementToBeClickable(interest));
        type(interest,"9.5");

        wait.until(ExpectedConditions.elementToBeClickable(tenure));
        type(tenure,"1");
    }


    public void printCarLoanResults() throws InterruptedException {
        scrollToElement(loanEmi);
        wait.until(ExpectedConditions.visibilityOf(loanEmi));

        Thread.sleep(3000);

        System.out.println("Loan EMI: "+loanEmi.getText());
        System.out.println("Total Interest Payable: "+totalInterest.getText());
        System.out.println("Total Payment: "+totalAmount.getText());
    }

    public String getLoanEmi(){
        return loanEmi.getText();
    }

    public String getTotalInterest() {
        return totalInterest.getText();
    }

    public String getTotalAmount() {
        return totalAmount.getText();
    }

}
