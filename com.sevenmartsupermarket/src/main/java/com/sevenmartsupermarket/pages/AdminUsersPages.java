package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminUsersPages {
WebDriver driver;
	PageUtility pageUtility=new PageUtility(driver);
	
	@FindBy(xpath="//h1[contains(text(),'Admin Users')]")
	WebElement header;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath="//input[@id='password']")
	WebElement userPassword;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement selectUserType;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	public AdminUsersPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHeader()
	{
		return header.getText();
	}
	public void clickNewButton()
	{
		newButton.click();
	}
	public void selectUserType(String visibleText)
	{
		pageUtility.select_ByVisibleText(selectUserType, visibleText);
	}

	public void addNewUser(String userName , String password , String selectType)
	{
		usernameField.sendKeys(userName);
		userPassword.sendKeys(password);
		selectUserType(selectType);
		saveButton.click();
	}
public String getAlertMessage()
{
	return alertText.getText();
	
}
}

