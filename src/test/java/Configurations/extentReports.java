package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReports 
{
	static ExtentHtmlReporter htmlReporter;
   static ExtentReports extent;
   static ExtentTest test;
    
	public static void setUpReport(String tcName)
	{
		htmlReporter = new ExtentHtmlReporter("./ExtentReports/"+tcName+"/testReport.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle(tcName+"_testReport");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        test = extent.createTest(tcName);
	}
	
	public static void testReport(Status status, String details)
	{
		test.log(status, details);
		
		
	}
	public static void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    }

}
