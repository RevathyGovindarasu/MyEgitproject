package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Configurations.ScreenShots;
import Configurations.extentReports;
import PageObjects.Identifiers;
import Utils.ExcelUtils;


public class HomePage {

	Identifiers ident = new Identifiers();
	public String pageName = "HomePage";
	HashMap<String,String> HomeData;
	public void HomePageActions(WebDriver driver, String testCase, String scenario) throws IOException
	{
		try
		{
			//WebDriverWait waitt = new WebDriverWait(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(ident.findTextBox(driver)));
		HomeData = ExcelUtils.getData(pageName, scenario);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ident.findTextBox(driver).sendKeys(HomeData.get("SearchText")+ Keys.ENTER);
	
		//ScreenShots.captureScreenshot(driver,pageName,scenario);
		extentReports.testReport(Status.PASS, "Home Page is working fine");
		}
		catch(Exception e)
		{
			extentReports.testReport(Status.FAIL, "Home Page has issues");
		}
	}
}
