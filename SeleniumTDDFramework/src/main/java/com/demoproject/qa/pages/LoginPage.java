package com.demoproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name = "email")
	WebElement email_field;
	
	@FindBy(name = "password" )
	WebElement password_field;
	
	@FindBy(xpath = "//*[@name='password']/parent::div/parent::div/following-sibling::div")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	
	// constructor to initialize
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// title = "Free CRM #1 cloud software for any business large or small";
	// actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
		
	public SignUpPage clickOnSignupBtn() {
		 signUpBtn.click();
		 return new SignUpPage();
	}
	
	public HomePage loginToCrm(String email,String password ) {
		email_field.sendKeys(email);
		password_field.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}
	
}
