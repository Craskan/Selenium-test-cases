package ChromeScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.security.Credential;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {
	//Declare Webdriver ,baseUrl
	 WebDriver driver;
	 String baseUrl;

	@BeforeClass
	 public void setup(){

	//Initialize the Chromedriver with exe file
	File ChromeDriver = new File("C:\\Selenium\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", ChromeDriver.getAbsolutePath());
 
	driver = new ChromeDriver();
	
	//Declare the url
	 baseUrl = "https://www.google.com/?gws_rd=ssl";
	//open the browser 
	 driver.get(baseUrl);
	//maximize the window
	driver.manage().window().maximize();		 
			 

	}

	@Test
	//okay to explain the inputs, arg1 is the value were testing, argId is where it gets placed,
	//action is how the value gets submitted and actionId is where.  The second half is for validation, expected, is a 
	//value we expected to get, and expectedId is where it should've been located.
	 public void Confirmation(String testPage,String arg1,String argId,String action,String actionId,String expected) throws AWTException {

	driver.get(testPage);

		 try {
			 driver.findElement(By.id(argId)).sendKeys(arg1);
			if(action == "click")
			{
			 driver.findElement(By.id(actionId)).click();
			}
			else if(action == "enter")
			{
				driver.findElement(By.id(actionId)).sendKeys(Keys.ENTER);
			}
			 
	 Thread.sleep(500);
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
		 

    }
	public boolean IsTestElementPresent(String element,String elementId)
	{
	    try
	    {
	        boolean returnable = false;
	    	WebElement temp = (driver.findElement(By.id(elementId)));
	    	
	    	if(temp.getText().equals(element)){
	    		returnable = true;
	    	}
			
	    	return returnable;
	    }

	    catch (NoSuchElementException e)
	    {
	    	System.out.println(e);
	        return false;
	    }
	    
	}
	@After
	public void tearDown() throws InterruptedException {
				
		//wait
		Thread.sleep(500);
		driver.close();
	}
	

}
