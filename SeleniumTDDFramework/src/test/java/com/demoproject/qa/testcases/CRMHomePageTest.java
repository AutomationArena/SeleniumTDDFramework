package com.demoproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoproject.qa.base.TestBase;
import com.demoproject.qa.pages.CRMHomePage;
import com.demoproject.qa.pages.HomePage;
import com.demoproject.qa.util.TestUtil;

public class CRMHomePageTest extends TestBase {
	
	CRMHomePage crmHomePage;
	
	public CRMHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		crmHomePage = new CRMHomePage();

	}
	
	
	@Test
	public void crmHomePageLogoTest() throws Exception{
		crmHomePage.validateLogo();
		TestUtil.takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+TestUtil.screenshot_count+".png");
	}
	
	@Test
	public void crmHomeAboutPageValidationTest() throws Exception {
		boolean result = crmHomePage.validateAboutPage();
		TestUtil.takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+TestUtil.screenshot_count+".png");
		Assert.assertEquals(result, true);
	}
	

		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
