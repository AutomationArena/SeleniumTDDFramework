package com.demoproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.demoproject.qa.util.TestUtil;
import com.demoproject.qa.util.WebEventListener;

public class TestBase {

	//class variables	
	public static WebDriver driver;
	public static Properties properties;
	public static  EventFiringWebDriver eventfiring_driver;
	public static WebEventListener eventListener;
	
	
	//constructor
	public TestBase(){
		// read the properties file
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("/home/globallogic/eclipse-workspace/SeleniumTDDFramework/src/main/java/com/demoproject/qa/config/config.properties");
			properties.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/drivers/chromedriver");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		eventfiring_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventfiring_driver.register(eventListener);
		driver = eventfiring_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
		
		 
		
	}
	
	
	
}
