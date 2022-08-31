package testCode.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCode.driver.DriverSingleton;

public class testCode1 {

private WebDriver driver;
	
	public testCode1() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div[1]/div/div/div/input")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id=\"zeus-root\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div[14]/div/div/div/div[2]/div/div/span")
	private WebElement readyStock;

	
	public void searchItem(String itemName) {
		search.click();
		search.sendKeys(itemName, Keys.ENTER);
	}
	
	public void scroollDown () throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1600)");
		Thread.sleep(200);
	}
	

	public void clickReadyStock() {
		readyStock.click();
	}
}
