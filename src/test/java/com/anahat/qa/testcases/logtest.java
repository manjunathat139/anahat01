package com.anahat.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class logtest{

		WebDriver driver;
		Logger log = Logger.getLogger(logtest.class);


		@BeforeMethod
		@Parameters("browser")
		public void setup(String browserName){
			log.info("****************************** Starting test cases execution  *****************************************");

			if(browserName.equalsIgnoreCase("FF")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/soft/geckodriver.exe");					
				driver=new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/soft/chromedriver.exe");					
				driver=new ChromeDriver();
			}if(browserName.equals("IE")){
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/soft/IEDriverServer.exe");
			    driver = new InternetExplorerDriver();
			}
			if(browserName.equals("edge")){
				
				System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/soft/MicrosoftWebDriver.exe");
			    driver = new EdgeDriver();
			}
			
			log.info("launching Firefox broswer");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("http://anahat.axxonet.me/home");
	//		driver.get("http://anahat.axxonet.me/home");
			log.info("entering application URL");
			log.warn("Hey this just a warning message");
			log.fatal("hey this is just fatal error message");
			log.debug("this is debug message");
		}


		@Test(priority=1)
		public void anahatTitleTest(){
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** anhatTitleTest *****************************************");
			String title = driver.getTitle();
			System.out.println(title);
			log.info("login page title is--->"+title);
			Assert.assertEquals(title,"Welcome - Anahat");

			log.info("****************************** ending test case *****************************************");
			log.info("****************************** anahatTitleTest *****************************************");

		}

		@Test(priority=2)
		public void anahtLogoTest(){
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** anahatLogoTest *****************************************");

			boolean b = driver.findElement(By.xpath("//img[@src='/html/themes/classic/images/anahat_logo_new.png']")).isDisplayed();
			Assert.assertTrue(b);

			log.info("****************************** ending test case *****************************************");
			log.info("****************************** anahatLogoTest *****************************************");

		}



		@AfterMethod
		public void tearDown(){
			driver.quit();
			log.info("****************************** Browser is closed *****************************************");


		}

}
