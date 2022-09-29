package com.anahat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.anahat.qa.base.TestBase;

public class HomePage extends TestBase
{

	@FindBy(xpath="//*[contains(text(),' Health Screening')]")
	WebElement healthScreeningLink;
	
	@FindBy(xpath="//*[contains(text(),' anahat admin ')]")
	WebElement loginUser;
	
	@FindBy(xpath="//a[@href='http://anahat.axxonet.me/group/anahat/home']")
	WebElement adaultLink;
	
	@FindBy(xpath="//*[contains(text(),' Children-Dashboard')]")
	WebElement childrenLink;

	
	@FindBy(xpath="//*[contains(text(),' BBMP Dashboard')]")
	WebElement  bbmpDashLink;
	
	@FindBy(xpath="//*[contains(text(),' BBMP Disease Profile')]")
	WebElement  bbmpDiseaseProfileLink;
	
	@FindBy(xpath="//*[contains(text(),' Admin Panel')]")
	WebElement  adminPanelLink;
	
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}
	public HealthScreeningPage clickOnHealthScreeningLink(){
		healthScreeningLink.click();
		return new HealthScreeningPage();
	}
	//Actions:
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectLoginUser(){
		return loginUser.isDisplayed();
	}
	
	public AdaultPage clickOnAdaultLink(){
		adaultLink.click();
		return new AdaultPage();
	}
	
	public ChildrenPage clickOnChildrenLink(){
		childrenLink.click();
		return new ChildrenPage();
	}
	
	
	
	public BbmpDashPage clickOnBbmpDashLink(){
		bbmpDashLink.click();
		return new BbmpDashPage();
	}
	
	public BmpDiseaseProfilePage clickOnBbmpDiseaseProfileLink(){
		bbmpDiseaseProfileLink.click();
		return new BmpDiseaseProfilePage();
	}
	
	public AdminPanelLinkPage clickOnAdminPanelLinkLink(){
		adminPanelLink.click();
		return new AdminPanelLinkPage();
	}
	
}
