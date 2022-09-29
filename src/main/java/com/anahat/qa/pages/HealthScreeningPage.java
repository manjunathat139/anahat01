package com.anahat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.anahat.qa.base.TestBase;

public class HealthScreeningPage extends TestBase 
{

	@FindBy(xpath="//select[@id='select-gender']")
	WebElement DemographicPage;
	
	@FindBy(xpath="//button[@id='button-filter']")
	WebElement filter;
	
	@FindBy(xpath="//tr[2]//td[1]")
	WebElement firstMatchingPatientlink;
	
	public HealthScreeningPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHealthScreeningTitle(){
		return driver.getTitle();
	}
	
	public DemographicPage selectGender() throws Exception
	{
		new Select(DemographicPage).selectByIndex(1);
		filter.click();
		Thread.sleep(10000);
		firstMatchingPatientlink.click();
		Thread.sleep(5000);
		return new DemographicPage();
	}
	
	
	
}
