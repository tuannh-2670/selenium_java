package selenium_practice1.main.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium_practice1.main.configDriver.DriverBase;

public class VibloPage extends BasePage {
	private String accessUrl = "https://accounts.viblo.asia/login";

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Tên người dùng hoặc email']")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement passwordInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div[3]/button")
	private WebElement loginBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[3]/form/div[1]/div/div[2]")
	private WebElement emailError;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/div/div[3]/form/div[2]/div/div[2]")
	private WebElement passwordError;

	public VibloPage() throws Exception {
		this.driver = DriverBase.buildSetupDriver();
		this.driver.get(accessUrl);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clearEmailInput() {
		emailInput.clear();
	}
	
	public void clearPasswordInput() {
		passwordInput.clear();
	}

	public void sendValueEmailInput(String value) {
		emailInput.sendKeys(value);
	}

	public void sendValuePasswordInput(String value) {
		passwordInput.sendKeys(value);
	}

	public String getEmailInputError() {
		return emailError.getText();
	}

	public String getPasswordInputError() {
		return passwordError.getText();
	}
}
