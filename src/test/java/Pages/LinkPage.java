package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Configurations.ScreenShots;
import Configurations.extentReports;
import PageObjects.Identifiers;


public class LinkPage {

	String pageName ="LinkPage";
	Identifiers ident = new Identifiers();
	
	public void linkPageActions(WebDriver driver,String scenario) throws IOException
	{
		try
		{
		ident.findLink(driver).click();
		ScreenShots.captureScreenshot(driver,pageName,scenario);
		extentReports.testReport(Status.PASS, "Link Page is working fine");
		}
		catch(Exception e)
		{
			extentReports.testReport(Status.FAIL, "Link Page has issues");
		}
	}
}
