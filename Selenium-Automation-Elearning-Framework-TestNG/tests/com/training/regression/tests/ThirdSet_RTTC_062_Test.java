package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ThirdSet_RTTC_062_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdSet_RTTC_062_Test {
	private static WebDriver driver;
	private static String baseUrl;
	private static ThirdSet_RTTC_062_POM rttc_062_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc_062_POM = new ThirdSet_RTTC_062_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
		
	
	@Test(dataProvider="excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void createRegister(String firstname,String lastname,String email,String phone,String address1, String address2,String city,String code,String country,String zone,String pwd,String cpwd) {
		rttc_062_POM.clickMenuBtn();
		rttc_062_POM.clickRegisterBtn();
		rttc_062_POM.sendFirstname(firstname);
		rttc_062_POM.sendLasttname(lastname);
		rttc_062_POM.sendEmail(email);
		rttc_062_POM.sendTelephone(phone);
		rttc_062_POM.sendAddress1(address1);
		rttc_062_POM.sendAddress2(address2);
		rttc_062_POM.sendCity(city);
		rttc_062_POM.sendPostalCode(code);
		rttc_062_POM.sendCountry(country);
		rttc_062_POM.sendRegion(zone);
		rttc_062_POM.sendPassword(pwd);
		rttc_062_POM.sendConfirmPassword(cpwd);
		rttc_062_POM.clickRediaoBtn();
		rttc_062_POM.clickCheckbox();
		rttc_062_POM.clickContinueButton();
		screenShot.captureScreenShot("Create multiple user");
		
		//Validating success msg
		String msg="Congratulations! Your new account has been successfully created!";
		assertEquals(rttc_062_POM.validateRegisterPOMMsg(),msg);
			System.out.println("RTTC_061 is executed properly");
			screenShot.captureScreenShot("User Registered");
	}
//		@AfterMethod
//		public void userLogout(){
//		rttc_062_POM.clickLogoutButton();
//		//rttc_062_POM.clickMenuBtn();
//		//rttc_062_POM.clickRegisterBtn();
		

}
