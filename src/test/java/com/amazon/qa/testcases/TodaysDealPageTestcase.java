package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.ProductDetailPage;
import com.amazon.qa.pages.TodaysDealsPage;

public class TodaysDealPageTestcase extends TestBase{
	
	
	
	 LoginPage loginPage;
	 HomePage homePage;
	 TodaysDealsPage todaysDealsPage;
	 ProductDetailPage productDetailPage;
	 CartPage cartPage;

	public TodaysDealPageTestcase() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		todaysDealsPage = new TodaysDealsPage();
		homePage.clickOnTodaysDeal();
		todaysDealsPage.clickOncheckboxAmazonDevice();
		productDetailPage =  new ProductDetailPage();
		cartPage = new CartPage();
	}
	
	@Test(priority = 1)
	public void validateDealsPageTest() {
		todaysDealsPage.verifyDealPageHeader();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2)
	public void validateCheckboxBtnTest() {
		boolean chkBox = todaysDealsPage.clickOncheckboxAmazonDevice();
		Assert.assertTrue(chkBox);
	}
	
	
	@Test(priority = 3)
	public void ValidatePeoductLink() {
		productDetailPage = todaysDealsPage.clickOnprodcutLink();
		 Assert.assertTrue(true);
	}
	
	@Test(priority = 4)
	public void validateAddtoCartBtn() {
		cartPage = todaysDealsPage.addtoCartProduct();
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
}
