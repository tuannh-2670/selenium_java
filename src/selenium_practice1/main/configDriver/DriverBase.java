package selenium_practice1.main.configDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
	public static WebDriver buildSetupDriver() {
		String pathGecko = "/home/nguyen.huu.tuanb/eclipse-workspace/selenium_java/src/selenium_practice1/lib/firefox/geckodriver";
		System.setProperty("webdriver.gecko.driver", pathGecko);
		return (WebDriver) new FirefoxDriver();
	}
}
