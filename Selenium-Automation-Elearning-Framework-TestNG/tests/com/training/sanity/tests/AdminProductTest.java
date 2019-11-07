package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminProductTest {
	
	private static WebDriver driver;
	private static String adminUrl;
	private static AdminProductPOM adminProductPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminProductPOM=new AdminProductPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot = new ScreenShot(driver); 
//open the browser 
		driver.get(adminUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void adminLoinTest(){
		adminProductPOM.sendAdminId("admin");
		adminProductPOM.sendAdminPwd("admin@123");
		adminProductPOM.clickLoginBtn();
		System.out.println("admin loggedIN successfully");
		screenShot.captureScreenShot("Admin Login");
	}
	@Test(priority=1)
	public void clickDashBtnTest(){
		adminProductPOM.clickDashBtn();
		System.out.println("clicked on dash tab");
		screenShot.captureScreenShot("Home page displayed");
		
	}
	@Test(priority=2)
	public void clickCatatlogtabtest(){
		adminProductPOM.clickCatalogBtn();
		System.out.println("clicked on catatlog tab");
		screenShot.captureScreenShot("Catalog page displayed");
	}
	
	@Test(priority=3)
	public void clickProducttabtest(){
		adminProductPOM.clickProductBtn();
		adminProductPOM.clickAddNewIcon();
		adminProductPOM.sendProductName("Finger ring");
		adminProductPOM.sendMetaTagTitle("Finger Ring for ladies");
		screenShot.captureScreenShot("captured product details");
	}
	@Test(priority=4)
	public void clickDatatabtest(){
		adminProductPOM.clickDataTab();
		adminProductPOM.sendModelid("SKU-012");
		adminProductPOM.sendPricevalue("500");
		adminProductPOM.sendQuantityvalue("50");
		screenShot.captureScreenShot("captured data tab details");
	}
	
	@Test(priority=5)
	public void clickLinksTabTest(){
		adminProductPOM.clickLinkTab();
		adminProductPOM.clickCategoryTextBox("Ear Rings");
		
	//adminProductPOM.selectCategory("647");  
		System.out.println("Links tab fields displayed");
		screenShot.captureScreenShot("Link tab");
	}
	
	@Test(priority=6)
	public void clickDiscountTabTest(){
		adminProductPOM.clickDiscountTab();
		adminProductPOM.clickAddDiscountIcon();
		adminProductPOM.sendDiscountQuantityvalue("1");
		adminProductPOM.sendDiscountPrice("50");
		adminProductPOM.clickStartDayicon();
		adminProductPOM.clickEndDayicon();
		System.out.println("Discount tab fields displayed");
		screenShot.captureScreenShot("Discount tab");
	}
	
	@Test(priority=7)
	public void clickRewardPointsTabTest(){
		adminProductPOM.clickRewardPointTab();
		adminProductPOM.sendPoints("20");
		adminProductPOM.clickSaveBtn();
		System.out.println("Rewardpoint tab fields displayed");
		screenShot.captureScreenShot("Reward points tab");
	}
	@Test(priority=8)
	public void validateSuccessmsgTest(){
		adminProductPOM.validatesuccessMsg();
		
		screenShot.captureScreenShot("Captured success msg");
	}
	

}
