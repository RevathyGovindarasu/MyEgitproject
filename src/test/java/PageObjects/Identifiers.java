package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Identifiers {

	public WebElement findTextBox(WebDriver driver)
	{
		WebElement element  = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		return element;
	}
	
	public WebElement findLink(WebDriver driver)
	{
		WebElement element  = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div[1]/a/h3"));
		return element;
	}

}
