package com.PCRM.base;
//added  base class

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.PCRM.util.TestUtility;

import webDriverListener.Webdriverlistner;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Webdriverlistner listener;
	public static EventFiringWebDriver e_driver;

	public BaseTest() {
		try {
			//reading property files 
			prop=new Properties();
			FileInputStream fis=new FileInputStream("/Users/ltatavarthy/EclipsPractice/POM_ProjectCRM/src/main/java/com/PCRM/config/config.properties");
			prop.load(fis);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException E) {
			E.printStackTrace();
		}
	}
	
		
		public void initialisation() {
			String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("chrome")) {		
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			}
		 else if (browserName.equalsIgnoreCase("firefox")) {

		}
			//Even Driver code
			e_driver=new EventFiringWebDriver(driver);
			listener=new Webdriverlistner();
			e_driver.register(listener);
			driver=e_driver;
			driver.manage().window().maximize();
			// driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICITLY_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
		
		public void terminate() {
			driver.quit();
		}
}

