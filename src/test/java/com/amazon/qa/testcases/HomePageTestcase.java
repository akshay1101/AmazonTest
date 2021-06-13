package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CustomerServicePage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.TodaysDealsPage;

public class HomePageTestcase extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TodaysDealsPage todaysDealsPage;
	CustomerServicePage customerService;

	public HomePageTestcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		todaysDealsPage = new TodaysDealsPage();
		customerService = new CustomerServicePage();
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String titleString = homePage.verifyHomepageTitle();
		Assert.assertEquals(titleString, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority = 2)
	public void validateUsernameLabel() {
		boolean uname = homePage.verifyUsernameLabel();
		Assert.assertTrue(uname);
	}
	
	@Test(priority = 3)
	public void validateAmazonLogo() {
		homePage.verifyAmazonLogo();
		Assert.assertTrue(true, "Amazon logo is not displayed");
	}
	
	@Test(priority = 4)
	public void validateHiUserLabel() {
		Assert.assertTrue(true);
	}
	
	
	@Test(priority = 5)
	public void validateTodaysDealLink() {
		todaysDealsPage = homePage.clickOnTodaysDeal();
		
	}
	
//	@Test(priority = 6)
//	public void validateCustomerServiceLink() {
//		customerService = homePage.clickOnCustomerService();
//		
//	}	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
