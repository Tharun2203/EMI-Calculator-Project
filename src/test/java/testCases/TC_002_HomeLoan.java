package testCases;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageObjects.HomeLoanPage;
import testBase.BaseClass;
import utils.ExcelUtils;

import java.util.List;

public class TC_002_HomeLoan extends BaseClass {


    ExtentTest test;
    @Test
    public void homeLoanStep2Test() {
        log.info("****** Started TC_002_HomeLoan ******");
        HomeLoanPage homeLoan = new HomeLoanPage(driver);


        log.info("Opening Home Loan EMI Calculator");
        homeLoan.openHomeLoanCalculator();


        log.info("Entering Home Loan Details till Date Picker");
        homeLoan.enterDetailsTillDatePicker();


        log.info("Capturing Screenshot and Extracting Year Wise Table Data");
        homeLoan.captureResultScreenshot();


        log.info("Writing Year Wise Table Data to Excel");
        List<List<String>> tableData = homeLoan.extractYearWiseTable();
        ExcelUtils.writeHomeLoanData("src/test/resources/testdata/HomeLoan_YearlyData.xlsx", tableData);

        log.info("**** Finished Test Case TC_002_HomeLoan ****");
    }
}
