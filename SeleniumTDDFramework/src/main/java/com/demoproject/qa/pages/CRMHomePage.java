package com.demoproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.qa.base.TestBase;

public class CRMHomePage extends TestBase {
	
	
			
	@FindBy(xpath = "(//a[@title='free crm home'])[1]")
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement aboutBtn;
	
	@FindBy(xpath = "//h1[contains(text(),'Free CRM About Us')]")
	WebElement aboutPageInfoHead;
	
	// constructor to initialize
	public CRMHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// actions
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public LoginPage clickOnLoginBtn(){
		loginBtn.click();
		return new LoginPage();
	}
	
	public SignUpPage clickOnsignUpBtn() {
		signupBtn.click();
		return new SignUpPage();
	}
	
	public boolean validateAboutPage() {
		aboutBtn.click();
		return aboutPageInfoHead.isDisplayed();
	}
		
}
