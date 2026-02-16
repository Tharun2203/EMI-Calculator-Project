package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import utils.ScreenshotUtil;

public class HomeLoanPage extends BasePage {

    public HomeLoanPage(WebDriver driver) {
        super(driver);
    }

    // ===== MENU =====
    @FindBy(xpath="//a[@id='menu-item-dropdown-2696']")
    WebElement loanMenu;

    @FindBy(xpath="//a[@title='Home Loan EMI Calculator']")
     WebElement homeLoanLink;

    // ===== INPUT FIELDS (TILL DATE PICKER) =====
    @FindBy(xpath="//input[@id='homeprice']")
    WebElement homeValue;

    @FindBy(xpath="//input[@id='downpayment']")
    WebElement downPayment;

    @FindBy(xpath="//input[@id='homeloaninsuranceamount']")
    WebElement loanInsurance;

    @FindBy(xpath="//input[@id='homeloanamount']")
    WebElement loanAmount;

    @FindBy(xpath="//input[@id='homeloaninterest']")
    WebElement loanInterest;

    @FindBy(xpath="//input[@id='homeloanterm']")
    WebElement loanTenure;

    @FindBy(xpath="//input[@id='loanfees']")
    WebElement loanFees;

    @FindBy(xpath="//input[@id='startmonthyear']")
    WebElement startMonthYear;

    @FindBy(xpath="//div[@class='homeloanpaymentsummary col-lg-8']")
    WebElement resultSection;


    @FindBy(xpath="//tr[contains(@class,'yearlypaymentdetails')]")
    List<WebElement> yearRows;



    // ---------------- METHODS ----------------

    public void openHomeLoanCalculator() {
        wait.until(ExpectedConditions.elementToBeClickable(loanMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(homeLoanLink)).click();
    }

    public void enterDetailsTillDatePicker() {

        wait.until(ExpectedConditions.visibilityOf(homeValue));

        type(homeValue, "8000000");
        type(downPayment, "20");
        type(loanInsurance, "0.5");
        type(loanAmount, "6400000");
        type(loanInterest, "7.5");
        type(loanTenure, "20");
        type(loanFees, "0.25");
        type(startMonthYear, "Feb 2026");
    }

    public void captureResultScreenshot() {
        scrollToElement(resultSection);
        hardWait(2);
        ScreenshotUtil.takeScreenshot(driver, "HomeLoanResultSection");
    }

    public List<List<String>> extractYearWiseTable() {

        scrollToElement(yearRows.get(0));
        wait.until(ExpectedConditions.visibilityOf(yearRows.get(0)));

        List<List<String>> tableData = new ArrayList<>();

        for (WebElement row : yearRows) {
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : row.findElements(By.tagName("td"))) {
                rowData.add(cell.getText().trim());
            }
            tableData.add(rowData);
        }
        return tableData;
    }
}
