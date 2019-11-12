package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminProductPOM;
import com.training.pom.Thirdset_RTTC_065_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdSet_RTTC_065_test {
	
	private static WebDriver driver;
	private static String adminUrl,baseUrl;
	private static Thirdset_RTTC_065_POM rttc_065_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc_065_POM=new Thirdset_RTTC_065_POM(driver);
		adminUrl = properties.getProperty("adminURL");
		baseUrl = properties.getProperty("baseURL");
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
		rttc_065_POM.sendAdminId("admin");
		rttc_065_POM.sendAdminPwd("admin@123");
		rttc_065_POM.clickLoginBtn();
		System.out.println("admin loggedIN successfully");
		screenShot.captureScreenShot("Admin Login");
	}
	@Test(priority=1)
	public void clickDashBtnTest(){
		rttc_065_POM.clickDashBtn();
		System.out.println("clicked on dash tab");
		screenShot.captureScreenShot("Home page displayed");
		
	}
	@Test(priority=2)
	public void clickCatatlogtabtest(){
		rttc_065_POM.clickCatalogBtn();
		System.out.println("clicked on catatlog tab");
		screenShot.captureScreenShot("Catalog page displayed");
	}
	
	@Test(priority=3)
	public void clickProducttabtest(){
		rttc_065_POM.clickProductBtn();
		rttc_065_POM.clickAddNewIcon();
		rttc_065_POM.sendProductName("Finger ring");
		rttc_065_POM.sendMetaTagTitle("Finger Ring for TC-65");
		screenShot.captureScreenShot("captured product details");
	}
	@Test(priority=4)
	public void clickDatatabtest(){
		rttc_065_POM.clickDataTab();
		rttc_065_POM.sendModelid("SKU-012");
		rttc_065_POM.sendPricevalue("520");
		rttc_065_POM.sendQuantityvalue("60");
		screenShot.captureScreenShot("captured data tab details");
	}
	
	@Test(priority=5)
	public void clickLinksTabTest(){
		rttc_065_POM.clickLinkTab();
		rttc_065_POM.clickCategoryTextBox("Ear Rings");
		rttc_065_POM.clickSaveBtn();
		rttc_065_POM.clickLogutBtn();
		
	//adminProductPOM.selectCategory("647");  
		System.out.println("Links tab fields displayed");
		screenShot.captureScreenShot("Link tab");
	}
	
	@Test(priority=6)
		public void checkuserpage() {
		driver.navigate().to(baseUrl);
			rttc_065_POM.sendtextinSearchBox("Finger Ring for TC-65");
			System.out.println("product fetched");
			screenShot.captureScreenShot("product details displayed");
		
		}
	}

