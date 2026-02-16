package utils;
import java.util.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReportInstance(){
        if(extent==null){
            ExtentSparkReporter spark=new ExtentSparkReporter("reports/EMI_Report.html");
            spark.config().setReportName("EMI Automation Report");
            spark.config().setDocumentTitle("EMI Test Results");

            extent= new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

}
