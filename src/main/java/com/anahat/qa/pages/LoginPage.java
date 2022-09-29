package com.anahat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.anahat.qa.base.TestBase;


public class LoginPage  extends TestBase
{
	
	// Page Factory Object Repository or WebElement Repository:
	@FindBy(id="demoemail")
	WebElement username;
	
	
	@FindBy(id="demopass")
	WebElement password;
	
	@FindBy(xpath="//div[@id='submit-button']")
	WebElement submit_button;
	
	@FindBy(xpath="//img[@src='/html/themes/classic/images/anahat_logo_new.png']")
	WebElement Anahatlogo;
	
	
	// Initializing the page objects:
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateAnahatImage(){
		return Anahatlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit_button.click();
		
		return new HomePage();
	}
	
	
}
