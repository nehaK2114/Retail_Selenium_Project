package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EditPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertEquals;

public class EditTest {
	
	private static WebDriver driver;
	private static String baseUrl;
	private static EditPOM editPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		editPOM=new EditPOM(driver);
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
		editPOM.clickMenuBtn();
		editPOM.sendEmailId("nehavivz1@gmail.com");
		editPOM.sendPassword("neha2114");
		editPOM.clickLoginBtn();
		System.out.println("User logged in successfully");
		
		//Perform Edit Operation
		editPOM.clickEditLink();
		editPOM.sendFirstName("Neha");
		editPOM.sendLastName("Prasad");
		editPOM.sendEmail("nehavivz26@gmail.com");
		editPOM.sendPhone("987654321");
		editPOM.clickContinue();
		screenShot.captureScreenShot("edit details");
	}
	@Test
	//
	public void validateEditLinkTest(){
		//Validating if Edit functionality perform successfully .
		String text="Success: Your account has been successfully updated.";
		assertEquals(editPOM.validateEditTest(),text);
		System.out.println("5th test case working as expected");
		screenShot.captureScreenShot("Captured updated details text");
		
	}

}
