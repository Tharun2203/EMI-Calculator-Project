package testCases;

import org.testng.annotations.Test;
import pageObjects.EmiCalculatorPage;
import testBase.BaseClass;

public class TC_003_EmiCalculatorValidation extends BaseClass {
    @Test
    public void validateSliderAndTextbox(){
        log.info("****** Started TC_003_EmiCalculator Tab ******");

        EmiCalculatorPage emiPage= new EmiCalculatorPage(driver);

        log.info("Validating Loan Amount Slider");
        emiPage.validateLoanAmount();

        log.info("Validating Interest Rate Slider");
        emiPage.validateLoanInterest();

        log.info("Validatig Loan Tenure Slider");
        emiPage.validateLoanTenure();

        log.info("Validating Fee Slider");
        emiPage.validateLoanFee();

        log.info("****** Completed TC_003_EmiCalculator ******");
    }
}
