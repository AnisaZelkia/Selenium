package testCode.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import testCode.driver.DriverSingleton;

public class Screenshots {

	public void takeScreenshotsFullPage(String nameFile) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DriverSingleton.getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("screenshots\\"+ nameFile + ".png");
		FileUtils.copyFile(src, target);
	}
	
	public void takeScreenshotsSectionPage(String selector, String nameFile) throws IOException {
		WebElement el = DriverSingleton.getDriver().findElement(By.xpath(selector));
		File src = el.getScreenshotAs(OutputType.FILE);
		File target = new File("screenshots\\"+ nameFile + ".png");
		FileUtils.copyFile(src, target);
	}
	
}
