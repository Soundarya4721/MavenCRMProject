package com.PCRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PCRM.base.BaseTest;

public class TestUtility extends BaseTest{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = "/Users/ltatavarthy/EclipsPractice/POM_ProjectCRM/src/main/java/com/PCRM/testdata/TestData.xlsx";
	static Workbook workbook;
	static Sheet sheet;

	@FindBy(name = "mainpanel")
	public WebElement frameid;

	public void ExplicitWait(int waitval) {
		WebDriverWait wait = new WebDriverWait(driver, waitval);
	}

	// over ridden method with a condition
	public void ExplicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}

	public void fluentwait(int timeout) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	public void HoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		actions.click();

	}

	// switch frame
	public void switchtoframe() {

		driver.switchTo().frame("mainpanel");
	}

	// Take Screenshot
		public static void takescreenshotatend() throws IOException {
			File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String crntDir = "/Users/ltatavarthy/EclipsPractice/CRMProject/Screenshots/";
			FileUtils.copyDirectory(scrfile, new File(crntDir + System.currentTimeMillis() + ".png"));

		}
		
		
   //Read data from excel
		
		public static Object[][] getTestData(String sheetname) {
			
			FileInputStream file=null;
			try {
				file=new FileInputStream(TESTDATA_SHEET_PATH);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
			workbook=WorkbookFactory.create(file);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			catch (InvalidFormatException e) {
				e.printStackTrace();
			}
			sheet=workbook.getSheet(sheetname);
			Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println(data[i][k]);
				}
			}
			return data;
		}
}
