package com.anahat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.anahat.qa.base.TestBase;

public class ReportPage extends TestBase
{
	@FindBy(xpath="//*[contains(text(),' Vital')]") 				    WebElement vital;
	
	@FindBy(xpath="//input[@name='cataract']") 				    		WebElement vitalCataract;
	@FindBy(xpath="//input[@name='other_eye']") 				    	WebElement vitalOther;
	@FindBy(xpath="//input[@name='long_sight']") 				    	WebElement vitalLong_Sight;
	
	
	
	
	
	@FindBy(xpath="//*[contains(text(),' Diagnosis')]") 				WebElement diagnosis;
	@FindBy(xpath="//input[@value='Diabetes']") 						WebElement diagnosisDiabetes;
	@FindBy(xpath="//input[@value='POH']") 						        WebElement diagnosisPOH;
	
	
	
	@FindBy(xpath="//button[@id='update-user-report-cancel']") 			WebElement cancelBtnReport;
	

	public ReportPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyReportPageTitle(){
		
		return driver.getTitle();
	}
	
	public void PatientVitalReports(String contaract, String other, String longSight ) throws Exception 	
	{		
	
	vital.click();
	vitalCataract.sendKeys(contaract);
	vitalOther.sendKeys(other);
	vitalLong_Sight.sendKeys(longSight);
	
	}
	public void PatientDiagnosisReports() throws Exception{
		
		diagnosis.click();
		diagnosisDiabetes.click();
		diagnosisPOH.click();
		Thread.sleep(5000);
		cancelBtnReport.click();
		
	}
	
	
}
