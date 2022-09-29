package com.anahat.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anahat.qa.base.TestBase;
import com.anahat.qa.pages.HomePage;
import com.anahat.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Adult - Dashboard - Anahat","Home Page Title not matched");
	}
	
	 @Test(priority=2)
	 public void verifyLoginUserTest() 
	 {
		 Assert.assertTrue(homePage.verifyCorrectLoginUser());
	 }
	 
	 @Test(priority=3)
		public void verifyHealthScreeningLinkTest(){
		homePage.clickOnHealthScreeningLink();
		}
	 @Test(priority=4)
		public void verifyAdaultLinkTest(){
		homePage.clickOnAdaultLink();
		}
	 @Test(priority=5)
		public void verifyAdminPanelLinkLinkTest(){
		homePage.clickOnAdminPanelLinkLink();
		}
	 @Test(priority=6)
		public void verifyBbmpDashLinkTest(){
		homePage.clickOnBbmpDashLink();
		}
	 @Test(priority=7)
		public void verifyBbmpDiseaseProfileLinkTest(){
		homePage.clickOnBbmpDiseaseProfileLink();
		}
	 @Test(priority=8)
		public void verifyChildrenLinkTest(){
		homePage.clickOnChildrenLink();
		}
	 
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
