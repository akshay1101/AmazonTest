package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTestcase extends TestBase{

	 LoginPage loginPage;
	 HomePage homePage;

	public LoginPageTestcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginpage();
		Assert.assertEquals(title, "Amazon Sign-In");
	}
	
	@Test(priority = 2)
	public void loginPageLogo() {
		boolean logo = loginPage.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void userLoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
}
