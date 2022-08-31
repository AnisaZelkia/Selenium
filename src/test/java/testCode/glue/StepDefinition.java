package testCode.glue;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.spring.CucumberContextConfiguration;
import testCode.config.AutomationFrameworkConfiguration;
import testCode.driver.DriverSingleton;
import testCode.pages.testCode1;
import testCode.screenshots.Screenshots;
import testCode.utils.ConfigurationProperties;
import testCode.utils.Constants;
import testCode.utils.TestCases;
import testCode.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

	private WebDriver driver;
	private Screenshots sc;
	
	private testCode1 testCode1;
	
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/main/resources/reportTestCodeTokopedia.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		report.attachReporter(htmlreporter);
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		
		sc = new Screenshots();
		
		testCode1 = new testCode1();
		
		TestCases[] tests = TestCases.values();
		extentTest = report.createTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}

	//////////////////////////////////

	@Given("^User go to the website")
	public void user_go_to_the_website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(Status.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("^User search item")
	public void user_search_item() throws IOException, InterruptedException {
		testCode1.searchItem(configurationProperties.getItemName());
		sc.takeScreenshotsSectionPage("//*[@id=\"zeus-root\"]/div/div[2]/div/div[2]/div[2]/span/div/span", "itemAvailable");
		extentTest.log(Status.PASS, "User search item", MediaEntityBuilder.createScreenCaptureFromPath(Constants.PATH_SCREENSHOT + "itemAvailable.png").build());
	}
	
	@And("User scrolldown")
	public void user_scrolldown() throws IOException, InterruptedException {
		testCode1.scroollDown();
		extentTest.log(Status.PASS, "User scrolldown");
	}
	
	@And("User click checkbox ready stock")
	public void user_click_checkbox_ready_stock() throws IOException {
		testCode1.clickReadyStock();
		extentTest.log(Status.PASS, "User click checkbox ready stock");
	}
	
	@And("User screenshoot ready stock item")
	public void user_screenshoot_ready_stock_item() throws IOException {
		sc.takeScreenshotsFullPage("stockItem");
		extentTest.log(Status.PASS, "User screenshoot ready stock item", MediaEntityBuilder.createScreenCaptureFromPath(Constants.PATH_SCREENSHOT + "stockItem.png").build());
	}
	

	@After
	public void closeObject() {
		report.flush();
	}

}
