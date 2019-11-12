package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminProductPOM;
import com.training.pom.Thirdset_RTTC_064_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ThirdSet_RTTC_064_Test {

		private static WebDriver driver;
		private static String adminUrl,baseUrl;
		private static Thirdset_RTTC_064_POM rttc_064_pom_dummy;
		private static Properties properties;
		private static ScreenShot screenShot;

		@BeforeMethod
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);

			driver = DriverFactory.getDriver(DriverNames.CHROME);
			rttc_064_pom_dummy=new Thirdset_RTTC_064_POM(driver);
			adminUrl = properties.getProperty("adminURL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			screenShot = new ScreenShot(driver); 
	//open the browser 
			driver.get(adminUrl);
		
		
		
			//admin loggedin to application
			  rttc_064_pom_dummy.sendAdminId("admin");
					rttc_064_pom_dummy.sendAdminPwd("admin@123");
					rttc_064_pom_dummy.clickLoginBtn();
					System.out.println("admin loggedIN successfully");
					screenShot.captureScreenShot("Admin Login");
		}
		
		@Test(dataProvider="excel-inputs", dataProviderClass = LoginDataProviders.class)
		public void adminCategoriesTest(String pname,String desc,String mtagtile,String mtagdesc){

		
		
			//admin Clicked on DashBoard section
			rttc_064_pom_dummy.clickDashBtn();
			System.out.println("clicked on dash tab");
			screenShot.captureScreenShot("Home page displayed");
			
			//admin Clicked on Catalog section
			rttc_064_pom_dummy.clickCatalogBtn();
			System.out.println("clicked on catatlog tab");
			screenShot.captureScreenShot("Catalog page displayed");
	
			//admin adding product
			rttc_064_pom_dummy.clickProductBtn();
			rttc_064_pom_dummy.clickAddNewIcon();
			rttc_064_pom_dummy.sendProductName(pname);
			rttc_064_pom_dummy.sendDescription(desc);
			rttc_064_pom_dummy.sendMetaTagTitle(mtagtile);
			rttc_064_pom_dummy.sendMetaTagDescription(mtagdesc);
			screenShot.captureScreenShot("captured product details");
			
			//admin adding data in Data tab
			rttc_064_pom_dummy.clickDataTab();
			rttc_064_pom_dummy.sendModelid("SKU-012");
			rttc_064_pom_dummy.sendPricevalue("520");
			rttc_064_pom_dummy.sendQuantityvalue("60");
			rttc_064_pom_dummy.clickDesignTab();
			screenShot.captureScreenShot("captured data tab details");
			
			//admin clicked on save button
			rttc_064_pom_dummy.clickSaveBtn();
			System.out.println("product saved");
			screenShot.captureScreenShot("captured saved product");
			
			//adming validating success msg
			rttc_064_pom_dummy.validatesuccessMsg();
			screenShot.captureScreenShot("Validated");
		
		
			}
	
		
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		

}
