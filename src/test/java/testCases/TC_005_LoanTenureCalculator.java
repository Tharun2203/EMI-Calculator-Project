package testCases;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.EmiCalculatorPage;
import pageObjects.LoanAmountCalculator;
import pageObjects.LoanTenureCalculator;
import testBase.BaseClass;

public class TC_005_LoanTenureCalculator extends BaseClass {
    @Test
    public void validateSlidersAndTextboxes(){
        log.info("****** Started TC_005_LoanTenureCalculator ******");

        LoanTenureCalculator tenurePage= new LoanTenureCalculator(driver);

        log.info("Validating Loan Amount Slider");
        tenurePage.validateLoanEmi();

        log.info("Validating EMI Slider");
        tenurePage.validateInterestRate();

        log.info("Validatig Interest Slider");
        tenurePage.validateTenure();

        log.info("Validating Fee Slider");
        tenurePage.validateFee();

        log.info("****** Completed TC_005_LoanTenureCalculator ******");
    }
}
