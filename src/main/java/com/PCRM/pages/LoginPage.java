package com.PCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PCRM.base.BaseTest;
import com.PCRM.util.TestUtility;

public class LoginPage extends BaseTest {

	TestUtility util=new TestUtility();
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifytitle() {
		String actualtitle = driver.getTitle();
		// Assert. assertEquals(actualtitle,)
		System.out.println(actualtitle);
	}

	public HomePage loginfunction() {
		// System.out.println(prop.getProperty("userid"));
		username.sendKeys(prop.getProperty("userid"));
		util.ExplicitWait(20);
		password.sendKeys(prop.getProperty("password"));
		util.fluentwait(10);
		loginbtn.click();
		return new HomePage();
	}
}
