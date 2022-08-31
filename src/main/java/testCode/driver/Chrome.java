package testCode.driver;

import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
	
	HashMap<String, Object> chromePrefs=new HashMap<>();	

	public WebDriver setStrategy() {
		
		String downloadFilePath = "C:\\KERJAAN\\IFG_LIFE\\testAutomationCode\\test_kerja\\downloads";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadFilePath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--no-sandbox");		

		return new ChromeDriver(options);
	}
}
