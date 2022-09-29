package com.anahat.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anahat.qa.base.TestBase;
import com.anahat.qa.pages.HealthScreeningPage;
import com.anahat.qa.pages.HomePage;
import com.anahat.qa.pages.LoginPage;

public class HealthScreeningPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	HealthScreeningPage health;
	
	public HealthScreeningPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage= new LoginPage();
		 health = new HealthScreeningPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHealthScreeningPageTitleTest(){
		homePage.clickOnHealthScreeningLink();
	String healthPageTitle=health.verifyHealthScreeningTitle();
	Assert.assertEquals(healthPageTitle, "Health Screening - Anahat","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyGenderTest() throws Exception
	{
		homePage.clickOnHealthScreeningLink();
		health.selectGender();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
