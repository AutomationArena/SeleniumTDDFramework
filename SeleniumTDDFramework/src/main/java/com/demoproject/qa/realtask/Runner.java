package com.demoproject.qa.realtask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demoproject.qa.util.TestUtil;

public class Runner {
	
	public static WebDriver driver;
	

	public static void main(String []args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://dailyuploads.net/o2g394fkxe70");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
	
		
		
		 
		Thread.sleep(5000);
		WebElement download_addon = driver.findElement(By.xpath("//*[@id='chkIsAdd']"));
		download_addon.click();
		Thread.sleep(5000);
		handle_browser(driver);
		
		System.out.println("Solve Capatch in 10 seconds");
		Thread.sleep(20000);
		
		
		 WebElement download_btn = driver.findElement(By.xpath("/*[@src='https://dailyuploads.net/images/redbutton.png']"));
		 download_btn.click();

		
		//*[@class='recaptcha-checkbox-border']
		//*[@id='downloadBtnClickOrignal']
		//*[@src='https://dailyuploads.net/images/redbutton.png']
		
	}
	
	
	
	public static void get_links() throws IOException{
		ArrayList links = MainRunner.extract_endpoints();
	}
	
	public static void handle_browser(WebDriver driver) {
		String mainWindow=driver.getWindowHandle();
		 // It returns no. of windows opened by WebDriver and will return Set of Strings
		 Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
			 String childWindow=itr.next();
			    // Compare whether the main windows is not equal to child window. If not equal, we will close.
			 if(!mainWindow.equals(childWindow)){
				 driver.switchTo().window(childWindow);
				 System.out.println(driver.switchTo().window(childWindow).getTitle());
				 driver.close();
				 }
		 }
			 // This is to switch to the main window
	     driver.switchTo().window(mainWindow);
	}
	
	
		

}
