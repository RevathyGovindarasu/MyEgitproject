package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Configurations.ConfigurationReader;
import Configurations.extentReports;
import Pages.HomePage;
import Pages.LinkPage;
import Utils.ExcelUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	ConfigurationReader conf = new ConfigurationReader();
	HomePage hp = new HomePage();
	LinkPage lp = new LinkPage();
	
	 WebDriver driver = null; 
		
	   @Before public void setUp(){ 
		   System.setProperty("webdriver.chrome.driver", conf.getDriverPath());
	      driver = new ChromeDriver();
	      driver.get(conf.getApplicationUrl());
	      driver.manage().window().maximize();
	      
	   } 
		
	
	   @Given("^when the url of \"([^\"]*)\" is given for the \"([^\"]*)\"$")
	   public void when_the_url_of_is_given_for_the(String pageType, String TestCase) throws Throwable {
		   System.out.println("This is "+pageType+ "method");
		   ExcelUtils.setupTestData(TestCase);
		   extentReports.setUpReport(TestCase);
		    hp.HomePageActions(driver, TestCase,pageType);
	   }

	   
	   @When("^lauches the url for the \"([^\"]*)\"$")
	   public void lauches_the_url_for_the(String scenario) throws Throwable {
		   System.out.println("This is when method");
		lp.linkPageActions(driver,scenario);
	}

	@Then("^page appears successfully$")
	public void page_appears_successfully() throws Throwable {
		System.out.println("This is then method");
	}
	
	@After public void cleanUp(){ 
		 extentReports.tearDown();
	      driver.close(); 
	     
	   } 
	
}
