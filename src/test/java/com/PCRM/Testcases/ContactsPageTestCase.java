package com.PCRM.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PCRM.base.BaseTest;
import com.PCRM.pages.ContactsPage;
import com.PCRM.pages.HomePage;
import com.PCRM.pages.LoginPage;
import com.PCRM.util.TestUtility;

public class ContactsPageTestCase extends BaseTest {
	
	TestUtility util;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage conpage;
	String sheetname = "Contact_Data";
	
	public ContactsPageTestCase() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialisation();
		util = new TestUtility();
		util.implicitWait();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test(priority = 1)
	public void login() {
		homepage = loginpage.loginfunction();

	}
	@Test(priority = 2)
	public void clickoncontacttab() {
		homepage.clickonnewcontact();

	}

	@Test(priority = 3)
	public void clicknewcntct() {
		conpage.clicknewcontact();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtility.getTestData(sheetname);
		return data;
		}
	

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void verifyaddcontactdetails(String FirstName, String LastName, String Phone) {
		conpage.addcontactdetails(FirstName, LastName, Phone);
	}

	@AfterTest
	public void quit() {
		terminate();
	}

}
