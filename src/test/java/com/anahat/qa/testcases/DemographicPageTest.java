package com.anahat.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anahat.qa.base.TestBase;
import com.anahat.qa.pages.DemographicPage;
import com.anahat.qa.pages.HealthScreeningPage;
import com.anahat.qa.pages.HomePage;
import com.anahat.qa.pages.LoginPage;
import com.anahat.qa.util.Util;

public class DemographicPageTest extends TestBase 
{

	LoginPage loginPage;
	HomePage homePage;
	Util testUtil;
	HealthScreeningPage health;
	DemographicPage demographic;
	HealthScreeningPage healthaScreening;
	String sheetName="DemographicData";
	
	
	public DemographicPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		 testUtil = new Util();
		loginPage= new LoginPage();
		 health = new HealthScreeningPage();
		 demographic = new DemographicPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyDemographicPageTitleTest() throws Exception{
		homePage.clickOnHealthScreeningLink();
		health.selectGender();
	String healthPageTitle=demographic.verifyDemographicPageTitle();
	Assert.assertEquals(healthPageTitle, "Health Screening - Anahat","Home Page Title not matched");
	}
	
	@DataProvider
	public Object[][] getAnahatTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getAnahatTestData")
	public void verifyDemographicDeatilesTest(String AadharNum, String MobileNum, String PName, String BBMPID, String GenderTitle ) throws Exception 
	{
		homePage.clickOnHealthScreeningLink();
		health.selectGender();	
		demographic.PatientDetailes(AadharNum, MobileNum, PName, BBMPID, GenderTitle); 
		demographic.PatientReports();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
