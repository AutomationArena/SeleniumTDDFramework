package com.demoproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	@FindBy(xpath = "//h2[contains(text(),'Register')]")
	WebElement registerTitle;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id="phone_number")
	WebElement phoneNumberField;
	
	@FindBy(id="terms")
	WebElement termsCheckBox;
	
	@FindBy(xpath = "//*[@id='recaptcha-anchor']")
	WebElement captchaCheckBox;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	
}
