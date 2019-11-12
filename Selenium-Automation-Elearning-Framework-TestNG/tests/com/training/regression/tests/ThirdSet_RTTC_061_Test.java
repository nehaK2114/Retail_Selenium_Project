package com.training.regression.tests;

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
import com.training.pom.RegisterPOM;
import com.training.pom.ThirdSet_RTTC_061_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdSet_RTTC_061_Test {
	private static WebDriver driver;
	private static String baseUrl;
	private static ThirdSet_RTTC_061_POM rttc_061_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
//	}
//
//	@BeforeMethod
//	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc_061_POM = new ThirdSet_RTTC_061_POM(driver); 
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
	public void createRegister() {
		rttc_061_POM.clickMenuBtn();
		rttc_061_POM.clickRegisterBtn();
		rttc_061_POM.sendFirstname("manzoor");
		rttc_061_POM.sendLasttname("mehadi");
		rttc_061_POM.sendEmail("manzoor100@gmail.com");
		rttc_061_POM.sendTelephone("9876543210");
		rttc_061_POM.sendAddress1("yeshwanthapur");
		rttc_061_POM.sendAddress2("Bangalore");
		rttc_061_POM.sendCity("Bangalore");
		rttc_061_POM.sendPostalCode("560022");
		rttc_061_POM.sendCountry("India");
		rttc_061_POM.sendRegion("Karnataka");
		rttc_061_POM.sendPassword("manzoor1");
		rttc_061_POM.sendConfirmPassword("manzoor1");
		rttc_061_POM.clickRediaoBtn();
		rttc_061_POM.clickCheckbox();
		rttc_061_POM.clickContinueButton(); 
		screenShot.captureScreenShot("Create user");
	}
		@Test
		public void validateRegister(){
			String msg="Congratulations! Your new account has been successfully created!";
			assertEquals(rttc_061_POM.validateRegisterPOMMsg(),msg);
				System.out.println("RTTC_061 is executed properly");
				screenShot.captureScreenShot("User Registered");
		
	}
}
