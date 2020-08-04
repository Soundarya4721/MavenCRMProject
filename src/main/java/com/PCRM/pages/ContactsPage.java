package com.PCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PCRM.base.BaseTest;
import com.PCRM.util.TestUtility;

public class ContactsPage extends BaseTest{

	TestUtility util=new TestUtility();
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement clickcontact;

	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement clicknewcontact;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	@CacheLookup
	WebElement ClickHome;

	@FindBy(name = "first_name")
	@CacheLookup
	WebElement FirstName;

	@FindBy(name = "phone")
	@CacheLookup
	WebElement Phone;

	@FindBy(name = "surname")
	@CacheLookup
	WebElement Lastname;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clicknewcontact() {
		util.switchtoframe();
		util.ExplicitWait(10);
		util.HoverOverElement(clickcontact);
		util.ExplicitWait(20);
		clicknewcontact.click();
		util.fluentwait(15);
		// ClickHome.click();
	}

	public void addcontactdetails(String Firstname, String LastName, String phnnum) {
		FirstName.sendKeys(Firstname);
		Lastname.sendKeys(LastName);
		Phone.sendKeys(phnnum);
	}

}
