package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.TestUtils;
import com.amazon.qa.util.WebdriverEventListener;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDirver;
	public static WebdriverEventListener eventListener;
	
		public TestBase() {
			
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\akkip\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			
			prop.load(ip);
		
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		public static void initialization() {
			
			String browserName = prop.getProperty("browser");
			
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akkip\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\akkip\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\akkip\\Downloads\\IEDriverServer_x64_3.9.0.IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		eventDirver = new EventFiringWebDriver(driver);
		// now create an object of WebdriverEventListener to register it with EventFiringWebDriver
		eventListener = new WebdriverEventListener();
		eventDirver.register(eventListener);
		driver = eventDirver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
