package testCases;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.EmiCalculatorPage;
import pageObjects.LoanAmountCalculator;
import testBase.BaseClass;

public class TC_004_LoanAmountCalculator extends BaseClass {
    @Test
    public void validateSliderAndTextbox(){
        log.info("****** Started TC_004_LoanCalculator Tab ******");

        LoanAmountCalculator loanPage= new LoanAmountCalculator(driver);

        log.info("Validating EMI Slider");
        loanPage.validateLoanEmi();

        log.info("Validating Interest Rate Slider");
        loanPage.validateInterestRate();

        log.info("Validatig Loan Tenure Slider");
        loanPage.validateTenure();

        log.info("Validating Fee Slider");
        loanPage.validateFee();

        log.info("****** Completed TC_004_LoanAmountCalculator ******");
    }
}
