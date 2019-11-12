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
import com.training.pom.ThirdSet_RTTC_063_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdSet_RTTC_063_Test {
	private static WebDriver driver;
	private static String baseUrl;
	private static ThirdSet_RTTC_063_POM rttc_063_POM;
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
		rttc_063_POM = new ThirdSet_RTTC_063_POM(driver); 
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
		rttc_063_POM.clickMenuBtn();
		rttc_063_POM.clickRegisterBtn();
		rttc_063_POM.sendFirstname(firstname);
		rttc_063_POM.sendLasttname(lastname);
		rttc_063_POM.sendEmail(email);
		rttc_063_POM.sendTelephone(phone);
		rttc_063_POM.sendAddress1(address1);
		rttc_063_POM.sendAddress2(address2);
		rttc_063_POM.sendCity(city);
		rttc_063_POM.sendPostalCode(code);
		rttc_063_POM.sendCountry(country);
		rttc_063_POM.sendRegion(zone);
		rttc_063_POM.sendPassword(pwd);
		rttc_063_POM.sendConfirmPassword(cpwd);
		rttc_063_POM.clickRediaoBtn();
		rttc_063_POM.clickCheckbox();
		rttc_063_POM.clickContinueButton();
		screenShot.captureScreenShot("getting error ");
		
		//Validating error msg
		String msg="Password must be between 4 and 20 characters!";
		assertEquals(rttc_063_POM.validateRegisterPOMMsg(),msg);
			System.out.println("RTTC_063 is executed properly");
			screenShot.captureScreenShot("User not able to register with invalid credentials");
	}

}
