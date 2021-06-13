package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory also called as object repository
	@FindBy(id = "ap_email")
	WebElement username;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement loginLinkbtn;
	
	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "continue")
	WebElement submitBtn;
	
	@FindBy(linkText = "Need help?")
	WebElement needhelpBtn;
	
	@FindBy(id = "createAccountSubmit")
	WebElement signupBtn;
	
	@FindBy(xpath = "//i[contains(@role,'img')]")
	WebElement logoElement;

	HomePage homepage;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		loginLinkbtn.click();

	}
	
	public String validateLoginpage() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		
		return logoElement.isDisplayed();
	}
	
	public HomePage login(String un, String pass) {
		
		username.sendKeys(un);
		submitBtn.click();
		password.sendKeys(pass);
		signInSubmit.click();	
		return new HomePage();
		
	}

	
}
