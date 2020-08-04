package com.PCRM.Testcases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PCRM.base.BaseTest;
import com.PCRM.pages.CalendarPage;
import com.PCRM.pages.HomePage;
import com.PCRM.pages.LoginPage;
import com.PCRM.util.TestUtility;

public class CalenderpageTest extends BaseTest {

	public CalenderpageTest(){
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	CalendarPage calpage;
	TestUtility util;
	String sheetname="Calendar_data";
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
	public void clickonclender() {
		calpage = homepage.clickcalenderpage();
	}

	@DataProvider
	public Object[][] getCaldendardata() {
		Object[][] data = TestUtility.getTestData(sheetname);
		return data;
		}
	
	@Test(priority = 3,dataProvider ="getCaldendardata")
	public void clickeventoncalenderpage(String name) {
		homepage = calpage.createEvent(name);
	}

	@AfterTest
	public void quit() {
		terminate();
	}

}
