package com.demoproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.qa.base.TestBase;

public class DealsPage extends TestBase{
//Object Repository.

	
	@FindBy(xpath = "//*[@id='button' and @aria-label='Notifications']")
	WebElement notificationsIcon;
	
	

	// constructor to initialize
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	// actions
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	

}
