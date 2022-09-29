package com.anahat.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.anahat.qa.base.TestBase;
import com.anahat.qa.pages.HomePage;
import com.anahat.qa.pages.LoginPage;




public class LoginPageTest extends TestBase
{
	
LoginPage loginPage;
HomePage homePage;



	public LoginPageTest(){
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp(){
		init();
	loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitle()
	
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome - Anahat");
		
		}
	
	@Test(priority=2)
	public void anahatLogoImageTest(){
		boolean flag= loginPage.validateAnahatImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
