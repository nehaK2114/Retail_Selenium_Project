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
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {
	
	private static WebDriver driver;
	private static String baseUrl;
	private static RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver); 
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
		registerPOM.clickMenuBtn();
		registerPOM.clickRegisterBtn();
		registerPOM.sendFirstname("sneha");
		registerPOM.sendLasttname("sharma");
		registerPOM.sendEmail("nehasharma2@gmail.com");
		registerPOM.sendTelephone("9345677833");
		registerPOM.sendAddress1("Jayanagar");
		registerPOM.sendAddress2("Bangalore");
		registerPOM.sendCity("Bangalore");
		registerPOM.sendPostalCode("560018");
		registerPOM.sendCountry("India");
		registerPOM.sendRegion("Karnataka");
		registerPOM.sendPassword("neha1234");
		registerPOM.sendConfirmPassword("neha1234");
		registerPOM.clickRediaoBtn();
		registerPOM.clickCheckbox();
		registerPOM.clickContinueButton(); 
		screenShot.captureScreenShot("createRegisterscreenshot");
	}
		@Test
		public void validateRegister(){
			String msg="Congratulations! Your new account has been successfully created!";
			assertEquals(registerPOM.validateRegisterPOMMsg(),msg);
				System.out.println("1st test case executed properly");
				screenShot.captureScreenShot("User Registered");
		
	}
	
	
}
