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
import com.anahat.qa.pages.ReportPage;
import com.anahat.qa.util.Util;

public class ReportPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	Util testUtil;
	HealthScreeningPage health;
	DemographicPage demographic;
	ReportPage report;
	
	String sheetName="Report";
	
	public ReportPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		testUtil = new Util();
		loginPage= new LoginPage();
		 health = new HealthScreeningPage();
		 demographic = new DemographicPage();
		 report=new ReportPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyReportPageTitleTest() throws Exception
	{
		homePage.clickOnHealthScreeningLink();
    	health.selectGender();
    	//demographic.PatientDetailes();
    	demographic.PatientReports();
	String reportTitle = report.verifyReportPageTitle();
	Assert.assertEquals(reportTitle, "Health Screening - Anahat","Home Page Title not matched");	
	}
	
	@DataProvider
	public Object[][] getAnahatTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getAnahatTestData")
	public void VitalReportTest(String contaract, String other, String longSight) throws Exception
	{
		homePage.clickOnHealthScreeningLink();
		health.selectGender();
		demographic.PatientReports();
		report.PatientVitalReports(contaract, other, longSight);
		report.PatientDiagnosisReports();
     }
	@Test(priority=3)
	public void DiagnosisReportTest() throws Exception{
		homePage.clickOnHealthScreeningLink();
		health.selectGender();
		demographic.PatientReports();
		report.PatientDiagnosisReports();
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
	
	
}
