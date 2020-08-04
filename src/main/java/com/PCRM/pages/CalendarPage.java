package com.PCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.PCRM.base.BaseTest;
import com.PCRM.util.TestUtility;

public class CalendarPage extends BaseTest {
	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	TestUtility util = new TestUtility();

	@FindBy(xpath = "//input[@id='title']")
	WebElement eventtitle;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement ClickHome;

	
	public HomePage createEvent(String name) {

		eventtitle.sendKeys(name);
		util.fluentwait(10);
		ClickHome.click();
		return new HomePage();

	}
}
