package testCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import testBase.BaseClass;

public class TC_001_CarLoan extends BaseClass {
    @Test
    public void carLoanTest() throws InterruptedException {
        log.info("****** Started TC_001_CarLoan ******");
        CarLoanPage carLoan=new CarLoanPage(driver);
        log.info("Selecting Car Loan Tab");
        carLoan.selectCarLoan();

        log.info("Entering Car Loan Details");
        carLoan.enterCarLoanDetails();

        log.info("Printing Car Loan Results into Console");
        carLoan.printCarLoanResults();

        log.info("***** * Finished Test Case TC_001_CarLoan ******");
    }
}
