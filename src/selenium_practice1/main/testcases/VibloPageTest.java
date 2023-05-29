package selenium_practice1.main.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import selenium_practice1.main.pageObject.VibloPage;

public class VibloPageTest {
	VibloPage vibloPage = null;

	@BeforeSuite
	public void initializeDriver() throws Exception {
		vibloPage = new VibloPage();
	}

	@AfterSuite
	public void closeBrowser() {
		vibloPage.quitDriver();
	}

	@Test
	public void checkLoginTitle() {
		Assert.assertEquals(vibloPage.getTitle(), "Viblo - Login");
	}

	@Test
	public void checkRequiredBothField() {
		vibloPage.clickLoginBtn();
		Assert.assertEquals(vibloPage.getEmailInputError(), "Tên người dùng/email là bắt buộc");
		Assert.assertEquals(vibloPage.getPasswordInputError(), "Mật khẩu là bắt buộc");
	}

	@Test
	public void checkRequiredEmail() {
		vibloPage.sendValueEmailInput("nguyen.huu.tuan-b@sun-asterisk.com");
		vibloPage.clickLoginBtn();
		Assert.assertEquals(vibloPage.getPasswordInputError(), "Mật khẩu là bắt buộc");
	}

	@Test
	public void checkRequiredPassword() {
		vibloPage.clearEmailInput();
		vibloPage.sendValuePasswordInput("Aa@123456");
		vibloPage.clickLoginBtn();
		Assert.assertEquals(vibloPage.getEmailInputError(), "Tên người dùng/email là bắt buộc");
	}
}
