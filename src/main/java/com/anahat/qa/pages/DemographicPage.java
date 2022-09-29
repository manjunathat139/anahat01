package com.anahat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.anahat.qa.base.TestBase;

public class DemographicPage extends TestBase
{

	@FindBy(xpath="//input[@name='aadhar_number']") 				    WebElement aadharnum;
	
	@FindBy(xpath="//input[@name='mobile_number']") 					WebElement mobnum;
	@FindBy(xpath="//input[@name='name']") 								WebElement name;
	@FindBy(xpath="//input[@name='bbmp_id']") 							WebElement bbmp_idNum;
	@FindBy(xpath="//select[@name='gender']") 							WebElement demoGender;
	
	
	
//	@FindBy(xpath="//select[@name='martial_status']") 					WebElement Marital_Status;
//	
//	@FindBy(xpath="//select[@name='no_children']") 						WebElement Num_of_children;
//	
//	@FindBy(xpath="//input[@name='marriage_age']") 						WebElement Estimated_marriage_age;
//		
//	@FindBy(xpath="//input[@name='dob']") 								WebElement DateOfBirth;
//	
//	@FindBy(xpath="//input[@name='age']") 								WebElement Age;
//	
//	@FindBy(xpath="//select[@name='education']") 						WebElement Education;
//	
//	@FindBy(xpath="//select[@name='occupation']") 						WebElement  Occupation;
//	
//	@FindBy(xpath="//select[@name='house_type']") 						WebElement  Type_of_House;
//	
//	@FindBy(xpath="//select[@name='toilet']") 							WebElement  Access_to_Toilet;
//	
//	@FindBy(xpath="//select[@name='water_con']") 						WebElement  Access_to_Water;
//	
//	@FindBy(xpath="//select[@name='ele_con']") 							WebElement  Electricity_in_House;
//	
//	@FindBy(xpath="//select[@name='doctor']") 							WebElement  which_doctor_do;
//	
//	@FindBy(xpath="//select[@name='asha_worker']")                		WebElement  ASHA_worker;
//	
//	@FindBy(xpath="//select[@name='reached_asha_worker']") 				WebElement  ASHA_workerhealth_related_concern;
//	
//	@FindBy(xpath="//select[@name='fuel']") 							WebElement  What_fuel;
//	
//	@FindBy(xpath="//select[@name='smoke']") 							WebElement  smokeOrdrink;
//	
//	@FindBy(xpath="//select[@name='working_hour']") 					WebElement  WorkingHours;
//	
//	@FindBy(xpath="//input[@value='Mask']") 							WebElement ProtectiveGearmask;
//	
//	@FindBy(xpath="//input[@value='Gloves']") 							WebElement ProtectiveGearGloves;
//	
//	@FindBy(xpath="//input[@value='Public Toilets']") 					WebElement PublicToilets;
//	
//	@FindBy(xpath="//input[@value='Do not drink water at work']") 		WebElement waterAtWork;
//	
//	@FindBy(xpath="//input[@value='None']") 							WebElement RiskInEverydayWaste;
//	
//	@FindBy(xpath="//input[@value='Easy to push']") 					WebElement PushcartEasyToPush;
//	
//	@FindBy(xpath="//select[@name='broom']") 							WebElement  Broom;
//	
//	@FindBy(xpath="//input[@value='Lower back']") 						WebElement body_pain;
//
//	@FindBy(xpath="//input[@value='Sexual assualt at work']") 			WebElement faced_situation;
//	
//	@FindBy(xpath="//select[@name='hours_sleep']") 						WebElement  sleep;
//	
//	@FindBy(xpath="//input[@value='Tired in the morning']") 			WebElement fatigue;
//	
//	@FindBy(xpath="//select[@name='tiffin_morning']") 					WebElement  Tiffin;
//	
//	@FindBy(xpath="//select[@name='segregate_waste']") 					WebElement  segregateWaste;
//	
//	//@FindBy(xpath="//button[@id='updateDemographic']") 					WebElement  updateDemo;
//	
	@FindBy(xpath="//tr[1]//td[1]")										WebElement firstMatchingPatientReportlink;
	
	public DemographicPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDemographicPageTitle(){
		return driver.getTitle();
	}
	public void PatientDetailes(String AadharNum, String MobileNum, String Pname, String BBMPID, String GenderTitle ) throws Exception 	
	{		
		Thread.sleep(5000);
	aadharnum.sendKeys(AadharNum);
	mobnum.sendKeys(MobileNum);
	name.clear();
	name.sendKeys(Pname);
	bbmp_idNum.sendKeys(BBMPID);
	new Select(demoGender).selectByVisibleText(GenderTitle);
 //  updateDemo.click();
  
		
	}
	
	public ReportPage PatientReports() throws Exception
	{
		firstMatchingPatientReportlink.click();
		return new ReportPage();
	}

}
