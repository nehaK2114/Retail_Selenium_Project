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
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginRetailTest {
	
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginRetailPOM loginRetailPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginRetailPOM=new LoginRetailPOM(driver);
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
		loginRetailPOM.clickMenuBtn();
		loginRetailPOM.sendEmailId("revasharma011@gmail.com");
		loginRetailPOM.sendPassword("reva123");
		loginRetailPOM.clickLoginBtn();
		System.out.println("User logged in successfully");
		screenShot.captureScreenShot("login");
	}
	
	@Test
	public void validateloginTest(){
		String expectedtitle="My Account";
		assertEquals(loginRetailPOM.validateRegisterPOMMsg(),expectedtitle);
		System.out.println("2nd test case executed properly");
		
		screenShot.captureScreenShot("verfiedLogin");
	}
}
