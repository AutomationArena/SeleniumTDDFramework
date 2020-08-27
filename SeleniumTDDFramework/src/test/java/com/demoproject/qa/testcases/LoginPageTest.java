package com.demoproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoproject.qa.base.TestBase;
import com.demoproject.qa.pages.CRMHomePage;
import com.demoproject.qa.pages.HomePage;
import com.demoproject.qa.pages.LoginPage;
import com.demoproject.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

CRMHomePage crmHomePage;
LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		crmHomePage = new CRMHomePage();
		loginPage = new LoginPage();

	}
	
	
	@Test
	public void loginPageTitleTest() throws Exception{
		String title = loginPage.validateLoginPageTitle();
		TestUtil.takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+TestUtil.screenshot_count+".png");
		Assert.assertEquals(title,  "Free CRM #1 cloud software for any business large or small");
		
	}
	
	@Test
	public void loginTest() {
		crmHomePage.clickOnLoginBtn();
		Assert.assertTrue(loginPage.loginToCrm("sandybadad@gmail.com", "Password@123") instanceof HomePage);
	}
	
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
