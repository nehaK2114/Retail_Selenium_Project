package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.InvalidLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InvalidLogin {
	private static WebDriver driver;
	private static String baseUrl;
	private static InvalidLoginPOM invalidLoginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		invalidLoginPOM=new InvalidLoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
    
	@Test
	public void loginTest(){
		invalidLoginPOM.clickMenuBtn();
		invalidLoginPOM.sendEmailId("abcdefgmail.com");
		invalidLoginPOM.sendPassword("123456");
		invalidLoginPOM.clickLoginBtn();
		System.out.println("Invalid credentials");
		screenShot.captureScreenShot("login with invalid data");
	}
	
	@Test
	public void validateInvalidloginTest(){
		String expectedmsg="Warning: No match for E-Mail Address and/or Password.";
		assertEquals(invalidLoginPOM.validateErrormsg(),expectedmsg);
		System.out.println("RTTC_031 executed properly");
		
		screenShot.captureScreenShot("verfied warning msg");
	}
}
