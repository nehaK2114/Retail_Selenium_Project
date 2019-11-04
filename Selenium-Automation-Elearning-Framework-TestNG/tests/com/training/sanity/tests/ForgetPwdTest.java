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
import com.training.pom.ForgetPwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ForgetPwdTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static ForgetPwdPOM forgetPwdPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		forgetPwdPOM=new ForgetPwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	public void validateforgetPwdTest(){
	
		forgetPwdPOM.clickMenuBtn();
		forgetPwdPOM.sendEmailId("reva22@gmail.com");
		forgetPwdPOM.sendPassword("JJJJJJ");
		forgetPwdPOM.clickLoginBtn();
		String expectedmsg="Warning: No match for E-Mail Address and/or Password.";
		assertEquals(forgetPwdPOM.validateForgetPwdMsg(),expectedmsg);
		
		//Clcik on forgotten pwd link
		forgetPwdPOM.clickForgotPwdLink();
		
		forgetPwdPOM.sendEmailId("revasharma011@gmail.com");
		forgetPwdPOM.clickSubmitBtn();
		System.out.println("3rd test case executed properly");
		screenShot.captureScreenShot("validatedForgetPwd");

}
	
	@Test(priority=1)
	//Validating after entering email id,received link for reset pwd
	public void validateResetmsgTest(){
		String expectedmsg="An email with a confirmation link has been sent your email address.";
		assertEquals(forgetPwdPOM.validateMsgafterrest(),expectedmsg);
		System.out.println("received confirmation email");
		screenShot.captureScreenShot("validatedResetPwdMSG");
		
	}
	
}
