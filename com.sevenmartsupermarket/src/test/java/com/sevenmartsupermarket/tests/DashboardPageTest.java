package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.DashboardPage;
import com.sevenmartsupermarket.pages.LoginPage;

public class DashboardPageTest extends Base{
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
@Test(groups="smoke")
public void verifyManagePageCardClickable()
{
	loginpage= new LoginPage(driver);
	dashboardpage= new DashboardPage(driver);
	loginpage.login();
	dashboardpage.navigateToCard("Admin Users");
}
}
