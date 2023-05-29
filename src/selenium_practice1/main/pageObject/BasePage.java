package selenium_practice1.main.pageObject;

import org.openqa.selenium.WebDriver;

public class BasePage {
	public WebDriver driver;
	
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
