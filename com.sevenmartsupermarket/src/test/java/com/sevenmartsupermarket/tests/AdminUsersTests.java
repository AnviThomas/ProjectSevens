package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUsersPages;
import com.sevenmartsupermarket.pages.DashboardPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class AdminUsersTests extends Base{

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AdminUsersPages adminuserpage;
	
	//ExcelReader excelreader=new ExcelReader();
	
	@Test
	public void verifyAdminUserHeader()
	{
		loginpage= new LoginPage(driver);
		dashboardpage= new DashboardPage(driver);
		adminuserpage=new AdminUsersPages(driver);
		
		loginpage.login();
		dashboardpage.navigateToCard("Admin Users");
		String actualHeader=adminuserpage.getHeader();
		System.out.println(actualHeader);
		String expectedHeader="Admin Users";
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	@Test
	public void verifyNewButtonisclickable()
	
	{
		
		
		loginpage= new LoginPage(driver);
		dashboardpage= new DashboardPage(driver);
		adminuserpage=new AdminUsersPages(driver);
		
		loginpage.login();
		dashboardpage.navigateToCard("Admin Users");
		adminuserpage.clickNewButton();
	}
	@Test
	public void userAdded()
	{
		loginpage= new LoginPage(driver);
		dashboardpage= new DashboardPage(driver);
		adminuserpage=new AdminUsersPages(driver);
		
		loginpage.login();
		dashboardpage.navigateToCard("Admin Users");
		adminuserpage.clickNewButton();
		
		adminuserpage.addNewUser("Anvi", "ygvd@ge" ,"Admin");
		
	}
@Test(groups={"smoke", "sanity"})
public void verifyAlertMessage()
{
	loginpage= new LoginPage(driver);
	dashboardpage= new DashboardPage(driver);
	adminuserpage=new AdminUsersPages(driver);
	
	loginpage.login();
	dashboardpage.navigateToCard("Admin Users");
	adminuserpage.clickNewButton();
	
	adminuserpage.addNewUser("THAnvi", "fvf@R%vv" ,"Admin");
	
	String actualAlertMessage=adminuserpage.getAlertMessage();
	System.out.println(actualAlertMessage);
	String expectedAlertMessage="Success";
	Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
}

}
