package com.anahat.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.anahat.qa.util.Util;
import com.anahat.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	

	public  static EventFiringWebDriver ev_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/eclipse/Anahat/src/main/java/config/properties/anahat.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void init(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			
		//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/soft/chromedriver.exe");	
			System.setProperty("webdriver.chrome.driver", "./soft/chromedriver.exe");	
			driver = new ChromeDriver(); 
			
		}
		else if(browserName.equals("FF")){
		}
		
		
		ev_driver = new EventFiringWebDriver(driver); 
		
		eventListener = new WebEventListener();
		ev_driver.register(eventListener);
		driver = ev_driver;
		
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
