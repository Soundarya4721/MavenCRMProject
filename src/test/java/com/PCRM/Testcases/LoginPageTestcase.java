package com.PCRM.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PCRM.base.BaseTest;
import com.PCRM.pages.HomePage;
import com.PCRM.pages.LoginPage;
import com.PCRM.util.TestUtility;

public class LoginPageTestcase extends BaseTest {
	
	TestUtility util;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTestcase() {
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
	public void gettitle() {
		loginpage.verifytitle();
		util.implicitWait();
	}

	@Test(priority = 2)
	public void verifyloginfunction() {
		homepage = loginpage.loginfunction();
	}

	@AfterTest
	public void quit() {
		terminate();
	}

}
