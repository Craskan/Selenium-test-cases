package EdgeScripts;

import java.io.Console;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class FirstEdgeTestCase {

	public static void main(String[] args) {
		String username = "your email username ie jackshultz@gmail.com";
		String password = "your password";
		
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
		
		WebDriver driver1 = null;
		try{
			driver1 = new EdgeDriver();
			System.out.println(driver1);
			driver1.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
			driver1.findElement(By.id("Email")).sendKeys(username);
			driver1.findElement(By.id("Email")).sendKeys(Keys.ENTER);
			//driver.findElement(By.id("next")).click();
			driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver1.findElement(By.id("Passwd")).sendKeys(password);
			driver1.findElement(By.id("Passwd")).sendKeys(Keys.ENTER);
			//driver.findElement(By.id("signIn")).click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally{
			if(driver1 != null)
			{
				//driver1.quit();
			}
		}
		
		//EdgeDriver driver = new EdgeDriver();
		
		//Session main = new Session();
		/*
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
		driver.findElement(By.id("Email")).sendKeys("calebkemp1@gmail.com");
		driver.findElement(By.id("Email")).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("next")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("Passwd")).sendKeys("StoneLee8");
		driver.findElement(By.id("Passwd")).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("signIn")).click();
		*/
	}

}
