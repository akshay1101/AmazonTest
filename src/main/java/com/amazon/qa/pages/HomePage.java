package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory or Object repo
	@FindBy(xpath = "//span[contains(text(), 'Hello, Test')]")
	WebElement userNameLabel;
	
	@FindBy(id = "nav-logo-sprites")
	WebElement amazonLogo;
	
	@FindBy(id = "glow-ingress-line2")
	WebElement countryName;
	
	@FindBy(xpath = "//h2[text()='Hi, Test']")
	WebElement hiUsernameLabel;
	
	@FindBy(xpath = "//div[@id='nav-xshop']/child::a[contains(text(),'Today')]")
	WebElement todaysDeals;
	
	@FindBy(xpath = "//div[@id='nav-xshop']/child::a[text()='Customer Service']")
	WebElement customerService;
	
	//Initialize the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions and methods
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsernameLabel() {
		 return userNameLabel.isDisplayed();
	}
	
	public boolean verifyAmazonLogo() {
		return amazonLogo.isDisplayed();
	}
	
	public String verifyCountryName() {
		return countryName.getText();
	}
	
	public boolean verifyHiUserNameLabel() {
		return hiUsernameLabel.isDisplayed();
	}
	
	public TodaysDealsPage clickOnTodaysDeal() {
		todaysDeals.click();
		return new TodaysDealsPage();
	}
	
//	public CustomerServicePage clickOnCustomerService() {
//		customerService.click();
//		return new CustomerServicePage();
//	}
	
	
	
	
}
