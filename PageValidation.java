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
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageValidation extends Credential{
		
		private WebDriver driver;
		private String baseUrl;
	
		@Before
		public void setUp() throws Exception {
			
			//this could be set to any file webdriver
			File ChromeDriver = new File("C:\\Selenium\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", ChromeDriver.getAbsolutePath());
			
			//creates the driver
			driver = new ChromeDriver();
			
			baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier";
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
		
		@Test//annotations
		public void Confirmationbox(String username, String password) throws InterruptedException, AWTException{
			
			driver.get(baseUrl);
			
			driver.manage().window().maximize();
			
			//create a robot for keyboard operations
			Robot rb = new Robot();
			
			//Enter user name by ctrl-v
			
			StringSelection user = new StringSelection(username);//username for Credentials class
			
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			
			//tab to password entry field
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			
			//Enter password by ctrl-v
			StringSelection pwd = new StringSelection(password);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd,null);
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			//wait
			Thread.sleep(5000);
			
		}
		
		@After
		public void tearDown() throws InterruptedException {
			
			//wait
			Thread.sleep(7000);
			driver.close();
		}

		@Override
		public boolean check(Object arg0) {
			// TODO Auto-generated method stub
			System.out.println("Authentication is successfull….WebSite is opened.");
			return false;
		}

	

}
