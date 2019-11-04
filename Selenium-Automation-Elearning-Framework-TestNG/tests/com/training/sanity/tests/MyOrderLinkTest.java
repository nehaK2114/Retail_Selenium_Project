package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MyOrderLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MyOrderLinkTest {
	
	private static WebDriver driver;
	private static String baseUrl;
	private static MyOrderLinkPOM myOrderLinkPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		myOrderLinkPOM=new MyOrderLinkPOM(driver);
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
	public void clickloginTest() throws InterruptedException{
		
		myOrderLinkPOM.clickMenuBtn();
		myOrderLinkPOM.sendEmailId("revasharma011@gmail.com");
		myOrderLinkPOM.sendPassword("reva123");
		myOrderLinkPOM.clickLoginBtn();
	}
		
		@Test(priority=1)
		public void clickMyOrderLinkTest(){
		//click on My Order link
		myOrderLinkPOM.clickMyOrderLink();
		System.out.println("clciked on My Order link");
		screenShot.captureScreenShot("my order link page shot");
		}
		
		@Test(priority=2)
		public void clickViewIconTest() throws Exception{
			
		//Click on View Icon
		myOrderLinkPOM.clickViewIcon();
		System.out.println("Clicked on View icon");
        Thread.sleep(3000);
			
	screenShot.captureScreenShot("view icon shot");
		}
			
	@Test(priority=3)
	//Validating if My order functionality perform successfully .
	public void validateMyOrderLinkTest(){
		String expectedtitle="Order Information";
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(expectedtitle));
		assertEquals(myOrderLinkPOM.validateMyOderLink(),expectedtitle);
		System.out.println("ordered product details should get displayed");
		System.out.println("4th test case worked fine");
		screenShot.captureScreenShot("verfied MYOrderLink");
	}
	}

