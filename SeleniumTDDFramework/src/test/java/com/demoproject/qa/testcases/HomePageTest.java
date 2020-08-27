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

public class HomePageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	CRMHomePage crmHomePage;

	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		homePage = new HomePage();
		loginPage = new LoginPage();
		crmHomePage = new CRMHomePage();
		crmHomePage.clickOnLoginBtn();
		loginPage.loginToCrm("sandybadad@gmail.com", "Password@123");
	}
	
	
	@Test
	public void homePageTitleTest() throws Exception{
		String title = homePage.validateHomePageTitle();
		TestUtil.takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+TestUtil.screenshot_count+".png");
		Assert.assertEquals(title,  "Cogmento CRM");
		
	}
	
	

		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
