package Configurations;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.io.FileUtils;

public class ScreenShots {
	public static void captureScreenshot(WebDriver driver, String pageName, String tcName) throws IOException
	{
		//TakesScreenshot ts = (TakesScreenshot)driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		 Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);                             
		  ImageIO.write(screenshot.getImage(),"PNG",new File("./Screenshots/"+tcName+"/"+pageName+".png"));
		//FileUtils.copyFile(screenshot.getImage(), new File("./Screenshots/"+tcName+"/"+pageName+".png"));
		System.out.println("the Screenshot is taken");
	}

}
