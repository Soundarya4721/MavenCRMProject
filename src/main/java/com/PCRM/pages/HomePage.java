package com.PCRM.pages;

import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.PCRM.base.BaseTest;
import com.PCRM.util.TestUtility;

public class HomePage extends BaseTest {
	TestUtility util = new TestUtility();
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Calendar')]")
	WebElement clickcalender;

	@FindBy(xpath = "//ul//li//a[@title='New Event']")
	WebElement ClickeventPage;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement clickcontact;

	@FindBy(name = "mainpanel")
	WebElement frameid;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public CalenderPage clickcalenderpage(String title) { for(WebElement
	 * elem:Homepagelist) { String text=elem.getText(); System.out.println(text);
	 * if(text.equalsIgnoreCase(title)) { elem.click(); break; } } return new
	 * CalenderPage(); }
	 */

	public CalendarPage clickcalenderpage() {
		util.switchtoframe();
		util.ExplicitWait(10);
		util.HoverOverElement(clickcalender);
		ClickeventPage.click();
		return new CalendarPage();
	}

	public ContactsPage clickonnewcontact() {
		util.switchtoframe();
		util.ExplicitWait(10);
		util.HoverOverElement(clickcontact);
		return new ContactsPage();

	}

}
