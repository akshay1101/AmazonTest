package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class ProductDetailPage extends TestBase{

	@FindBy(id = "productTitle")
	WebElement ProductName;
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyProductIsavailable() {
		return ProductName.getText();
	}
}
