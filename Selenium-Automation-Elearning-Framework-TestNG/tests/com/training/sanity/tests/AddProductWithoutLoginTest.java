package com.training.sanity.tests;

import java.io.FileInputStream;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductWithoutLoginPom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductWithoutLoginTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static AddProductWithoutLoginPom addProductWithoutLoginPom;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addProductWithoutLoginPom=new AddProductWithoutLoginPom(driver);
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
	public void addProductWithoutLogin(){
		addProductWithoutLoginPom.clickLinkBtn();
		addProductWithoutLoginPom.clickAddtoCartBtn();
		addProductWithoutLoginPom.hoveroncartIcon();
	}
	
	
	
	@Test(priority=1)
	public void validateCartMsgTest(){
		
		System.out.println(addProductWithoutLoginPom.validateCartMsg());
		screenShot.captureScreenShot("Added product");
		
	}
	@Test(priority=2)
	public void clickViewCartBtnTest(){
		addProductWithoutLoginPom.clickViewCartBtn();
		System.out.println("Product details containing Image, Product Name, Model, Quantity, Unit Price & Total should get displayed");
		screenShot.captureScreenShot("Clicked on View Cart");
	}
	
	@Test(priority=3)
	public void clickChkoutBtnTest(){
		addProductWithoutLoginPom.clickCheckoutBtn();
		screenShot.captureScreenShot("Clicked on Checkout");
		
	}
	
	@Test(priority=4)
	public void getLoginPageTest(){
		String title="Checkout";
		assertEquals(addProductWithoutLoginPom.LoginpageDisplayed(), title);
		System.out.println("User return to Login page");
		screenShot.captureScreenShot("Login Page");
	}

}
