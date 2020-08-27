package com.demoproject.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoproject.qa.base.TestBase;
import com.demoproject.qa.pages.CRMHomePage;
import com.demoproject.qa.pages.ContactsPage;
import com.demoproject.qa.pages.HomePage;
import com.demoproject.qa.pages.LoginPage;
import com.demoproject.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactsPage;
	HomePage homePage;
	LoginPage loginPage;
	CRMHomePage crmHomePage;
	String sheetname ="Contacts";

	
	public ContactsPageTest() {
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
		contactsPage = new ContactsPage();
	}
	
	@DataProvider
	public Object[][] getTestdata(){
//		Object[][] data = new Object[][];
		Object[][] data = TestUtil.getTestData(sheetname);
		System.out.println("data is "+ data);
		return data;
	}
	
	
	//@Test 
	public void contactsPageHeadTest() throws Exception{
		homePage.gotoContactsPage();
		boolean heading = contactsPage.validateContactsPageHead();
		TestUtil.takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+TestUtil.screenshot_count+".png");
		Assert.assertTrue(heading);
	}
	
//	@Test 
	public void contactPresentTest() throws Exception{
		homePage.gotoContactsPage();
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement contact = contactsPage.findContact("Phone","+911234567890"); //("Name","Arun Kumar R");
		System.out.println(contact);
		Assert.assertTrue(contact instanceof WebElement);
	}
	
	@Test(dataProvider="getTestdata")
	public void createNewContactsTest(String firstname, String middlename, String lastname, String company, String email , String alternate_email, String socialChannelName, String socialChannelLink) throws InterruptedException {
		homePage.gotoContactsPage();
//		contactsPage.creatNewContact("san", "b" , "b", "GL", "sandybb@gl.com", "sandybb@pm.com", "Facebook", "sandyB");
//		String contact_head_xpath = "//*[@id='dashboard-toolbar']/div[text()='"+"sandeep"+" "+"b"+"']";
		System.out.println("Running ........................");
		contactsPage.creatNewContact(firstname, middlename, lastname, company, email, alternate_email, socialChannelName, socialChannelLink);
		String newContactName= driver.findElement(By.xpath("(//*[@id='dashboard-toolbar']/div)[1]")).getText();
		
		Assert.assertEquals(newContactName, firstname+" "+lastname);
	}
	
	

		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
