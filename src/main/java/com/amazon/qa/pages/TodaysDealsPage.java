package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class TodaysDealsPage extends TestBase{
	
	//Page Factory or Object repo
	@FindBy(xpath = "//div[@id='nav-xshop']//child::a[contains(text(),'Today')]")
	WebElement todaysDealBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Amazon Devices')]//preceding-sibling::input")
	WebElement amazonDeviceCheckbox;
	
	@FindBy(xpath = "//p[text()='Shop Today’s Deals, Lightning Deals, and limited-time discounts']")
	WebElement dealPageheader;
	
	 @FindBy(id = "dealTitle")
	 WebElement productElement;
	 
	 @FindBy(xpath = "//button[@id='100 d9566046-announce']")
	 WebElement addToCartBtn;
	 
	 //Constuctor
	public TodaysDealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealPageHeader() {
		return dealPageheader.isDisplayed();	
		
	}
	
	public boolean clickOncheckboxAmazonDevice() {
		amazonDeviceCheckbox.click();
		return amazonDeviceCheckbox.isEnabled();
	}
	
	public ProductDetailPage clickOnprodcutLink() {
		productElement.click();
		return new ProductDetailPage();
	}
	
	public CartPage addtoCartProduct() {
		addToCartBtn.click();
		return new CartPage();
	}
	
	
}
