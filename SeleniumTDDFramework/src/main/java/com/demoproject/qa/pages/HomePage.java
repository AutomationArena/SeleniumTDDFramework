package com.demoproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.qa.base.TestBase;

public class HomePage extends TestBase{

	//Object Repository.

	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactspagelink;
	
	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	WebElement companiespagelink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement  dealspagelink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement taskspagelink;
	
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Search']")
	WebElement searchField;
	
	@FindBy(xpath = "//*[@class='pin icon']")
	WebElement pinnedRecordsBtn;
	
	@FindBy(xpath = "//*[@class='trash alternate outline icon']")
	WebElement trashBtn;
	
	@FindBy(xpath = "//*[@role='listbox']")
	WebElement listAcccountsettingsBtn;
	
	

	// constructor to initialize
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage gotoContactsPage() {
		contactspagelink.click();
		return new ContactsPage();
	}
	
	public CompaniesPage gotoCompaniesPage() {
		companiespagelink.click();
		return new CompaniesPage();
	}
	
	public DealsPage gotoDealsPage() {
		dealspagelink.click();
		return new DealsPage();
	}
	
	public TasksPage gotoTaskspage() {
		taskspagelink.click();
		return new TasksPage();
	}
	
	// actions
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	


	
}
