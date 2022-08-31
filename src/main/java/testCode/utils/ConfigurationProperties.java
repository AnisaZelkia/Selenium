package testCode.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${itemName}")
	private String itemName;

	////////////////////////////////////////////////////////////////////////

	public String getBrowser() {
		return browser;
	}
	
	public String getItemName() {
		return itemName;
	}

}
