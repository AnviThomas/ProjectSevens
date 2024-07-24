package com.sevenmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.DashboardPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;



public class LoginTest extends Base {
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ExcelReader excelreader =new ExcelReader();
	@Test(groups="smoke")
	public void verifyLogin()
	{
		
		loginpage= new LoginPage(driver);
		dashboardpage=new DashboardPage(driver);
		
		//loginpage.login();
		loginpage.login("admin","admin");
		
		String actualProfileName=dashboardpage.getProfileName();
		System.out.println(actualProfileName);
		String expecetedProfileName="Admin";
		
		excelreader.setExcelFile("Logindata", "credentials");
		String data =excelreader.getCellData(0, 0);
		System.out.println("username is :" +data );
		Assert.assertEquals(actualProfileName, expecetedProfileName);
		
		
		
	}
	@Test (groups="sanity")
	public void verifyInvalidLogin()
	{
		
	
		loginpage= new LoginPage(driver);
		loginpage.login("123","admin");
		String actualAlertMsg=loginpage.getAlertMessage();
		System.out.println(actualAlertMsg);
		String expectedAlertMsg="New";
		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMsg));
		
	}

}
/*ScreenshotCaptcher screenshotCaptcher=new ScreenshotCaptcher();
		screenshotCaptcher.takeScreenshot(driver, "Anvi");*/


