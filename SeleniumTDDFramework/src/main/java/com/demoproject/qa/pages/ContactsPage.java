package com.demoproject.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoproject.qa.base.TestBase;

public class ContactsPage extends TestBase{


	
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsHeadInDashboard;
	
	@FindBy(xpath = "//button[contains(text(),'Show Filters')]")
	WebElement showFiltersBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Hide Filters')]")
	WebElement hideFiltersBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Export')]")
	WebElement exportBtn;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement createnewBtn;
	
	// create new contact elements
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstNameField;
	
	@FindBy(name = "middle_name") 
	WebElement middleNameField;
	
	@FindBy(name = "last_name")
	WebElement lastNameField;
	
	@FindBy(xpath = "//label[contains(text(),'Company')]/following-sibling::div/input")
	WebElement companyField;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddressFiled;
	
	@FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']")
	WebElement alternateEmailField;
	
	@FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']/parent::div/following-sibling::button")
	WebElement addMoreEmails;
	
	@FindBy(name = "description")
	WebElement descriptionField;
	
	@FindBy(xpath = "//*[@name='channel_type']")
	WebElement socialChannelDropdown;
	
	@FindBy(xpath = "//*[@name='channel_type']/following-sibling::div/input")
	WebElement socailChannelLink;
	
	@FindBy(xpath = "//*[@name='channel_type']/following-sibling::div/following-sibling::button")
	WebElement addMoreSocialChannel;
		
	@FindBy(xpath = "//*[@name='timezone']")
	WebElement timezoneSelect;
	
	@FindBy(name = "address")
	WebElement addressField;
	
	@FindBy(name = "city")
	WebElement cityField;
	
	@FindBy(name = "state")
	WebElement stateField;

	@FindBy(name = "zip")
	WebElement zipcodeField;
	
	@FindBy(xpath = "//*[@name='country']")
	WebElement countryField;
	
	@FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::div//input[@aria-autocomplete='list']")
	WebElement countryCodePhone;
	
	@FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::div//input[@placeholder='Number']")
	WebElement phoneNumberField;
	
	@FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::div//input[@placeholder='Home, Work, Mobile...']")
	WebElement alternatePhoneNumberField;
	
	@FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::div//button")
	WebElement addMorePnoneNumbers;
		
	@FindBy(name = "position")
	WebElement positionField;

	@FindBy(name = "department")
	WebElement departmentField;
		
	@FindBy(xpath = "//*[@name='supervisor']")
	WebElement supervisorField;
	
	@FindBy(xpath = "//*[@name='assistant']")
	WebElement assistantField;
	
	@FindBy(xpath = "//*[@name='status']")
	WebElement statusDropdown;
	
	@FindBy(xpath = "//*[@name='source']")
	WebElement sourceDropdown;
	
	@FindBy(xpath = "//*[@name='category']")
	WebElement categoryDropdown;
	
	@FindBy(xpath = "//*[@name='do_not_call']")
	WebElement doNotCallToggleBtn;
	
	@FindBy(xpath = "//*[@name='do_not_text']")
	WebElement doNotTextToggleBtn;
	
	@FindBy(xpath = "//*[@name='do_not_email']")
	WebElement doNotEmailToggleBtn;
	
	@FindBy(name = "day")
	WebElement dayField;
	
	@FindBy(xpath = "month")
	WebElement monthDropdown;
	
	
	@FindBy(xpath = "year")
	WebElement yearField;
		
	@FindBy(name = "identifier")
	WebElement identifierField;
	
	@FindBy(name = "image")
	WebElement imageUploadField;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
		
	// constructor to initialize
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	// actions
	public boolean validateContactsPageHead() {
		return contactsHeadInDashboard.isDisplayed();
	}
	
	public void creatNewContact(String firstname, String middlename , String lastname , String company , String email, String alternateEmail , String socialChannel , String socialAccount) throws InterruptedException {
		createnewBtn.click();
		boolean pageReloaded =false;
		if (pageReloaded == false) {
			driver.navigate().refresh();
			 try{
				 System.out.println("Re-attempting"); 
				 if(firstNameField.isDisplayed()) {
					 pageReloaded = true;
				 }
			 }catch (NoSuchElementException e) {
				 driver.navigate().refresh();
			 }
		}
		Thread.sleep(3000);
		firstNameField.sendKeys(firstname);
		middleNameField.sendKeys(middlename);
		lastNameField.sendKeys(lastname);
		companyField.sendKeys(company);
		emailAddressFiled.sendKeys(email);
		alternateEmailField.sendKeys(alternateEmail);
		socialChannelDropdown.click();
		String socialChannel_xpath = "//*[@name='channel_type']//span[contains(text(),'"+socialChannel+"')]";
		driver.findElement(By.xpath(socialChannel_xpath)).click();
		socailChannelLink.sendKeys(socialAccount);
		Thread.sleep(5000);
		saveBtn.click();
		Thread.sleep(5000);
	}
	
		
	public List<WebElement> getContactList(){
		List<WebElement> contacts = driver.findElements(By.xpath("//*[@id='dashboard-toolbar']/following-sibling::div//tbody/tr"));
		return contacts;
	}
	
	public HashMap<String,Integer>  contactDetailColumnHeadings(){
		Map<String,Integer> detail_col =  new HashMap<String, Integer>(){{
			put("Name" ,1);
			put("Company" , 2);
			put("Category" ,3);
			put("Status",4);
			put("Address",5);
			put("Phone",6);
			put("Email",7);
		}};
		return (HashMap<String, Integer>) detail_col;
	}
	
	public WebElement findContact(String findBy , String matcher) throws InterruptedException {
		List<WebElement> contacts = getContactList();
		Iterator<WebElement> i = contacts.iterator();
		HashMap<String,Integer> detail_col_no =  contactDetailColumnHeadings();
		Thread.sleep(2000);
		while(i.hasNext()) {
			WebElement contact = i.next();
			List<WebElement> contact_details = contact.findElements(By.tagName("td"));
			String contact_detail = contact_details.get(detail_col_no.get(findBy)).getText();
			System.out.println(contact_detail);
			System.out.println("Contact detail " + contact_detail +"  matcher is "+ matcher+ "  matched "+ contact_detail.equals(matcher));
			if (contact_detail.equals(matcher)){
				return contact;
			} 
		}
		return null;
	}
	
	public List<WebElement> getContactDetails(WebElement Contact){
		List<WebElement> contactDetails = Contact.findElements(By.xpath("//*[@id='dashboard-toolbar']/following-sibling::div//tbody/tr"));
		return contactDetails;
	}
	
	public void findDetailOfAContact( String cont_name) {
		driver.navigate().refresh();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> contact_details = getContactList().get(1).findElements(By.tagName("td"));
//		List<WebElement> contacts= getContactList();
//		Iterator<WebElement> i = contacts.iterator();
//		while(i.hasNext()) {
//			WebElement contact = i.next();
//			List<WebElement> contact_details = contact.findElements(By.tagName("td"));
//			String contact_detail = contact_details.get(col_no_detail).getText();
//			System.out.println(contact_detail);
//		}
	}
	

}
