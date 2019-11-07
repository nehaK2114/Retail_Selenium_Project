package com.training.sanity.tests;

import java.io.FileInputStream;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductWithLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductWithLoginTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static AddProductWithLoginPOM addProductWithLoginPom;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addProductWithLoginPom=new AddProductWithLoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void Login(){
		addProductWithLoginPom.clickMenuBtn();
		addProductWithLoginPom.sendEmailId("revasharma011@gmail.com");
		addProductWithLoginPom.sendPassword("reva123");
		addProductWithLoginPom.clickLoginBtn();
	}
	@Test(priority=1)
	public void addProduct(){
		addProductWithLoginPom.clickHomeLink();
		addProductWithLoginPom.clickProductBtn();
		addProductWithLoginPom.clickAddtoCartBtn();
		//addProductWithLoginPom.hoveroncartIcon();
		screenShot.captureScreenShot("added product");
	}
	
	
	
	@Test(priority=2)
	public void validateCartMsgTest(){
		
		System.out.println(addProductWithLoginPom.validateCartMsg());
		screenShot.captureScreenShot("Validated cart msg");
		
	}
	@Test(priority=3)
	public void clickViewCartBtnTest(){
		addProductWithLoginPom.clickViewCartBtn();
		System.out.println("Product details containing Image, Product Name, Model, Quantity, Unit Price & Total should get displayed");
		screenShot.captureScreenShot("clicked on View cart");
	}
	
	@Test(priority=4)
	public void clickChkoutBtnTest(){
		addProductWithLoginPom.clickCheckoutBtn();
		System.out.println("Billing Details should get displayed");
		screenShot.captureScreenShot("clicked on Billing details");
		
	}
	
	@Test(priority=5)
	public void clickContinueBtnTest(){
		addProductWithLoginPom.clickContinueBtn();
		System.out.println("Delivery Details should get displayed");
		screenShot.captureScreenShot("clicked on Delivery details");
		
	}
	@Test(priority=6)
	public void clickDeliveryBtnTest(){
		addProductWithLoginPom.clickDeliveryBtn();
		System.out.println("Free Shipping radio button should get selected & Add Comments About Your Order textbox should get displayed");
		addProductWithLoginPom.clickDeliveryBtn();
		screenShot.captureScreenShot("clicked on Delivery mrthod details");
	}
	
	@Test(priority=7)
	public void enterCommenttextTest(){
		
		addProductWithLoginPom.enterComment("This product is nice");
		System.out.println("entered credentials should get displayed in Add Comments About Your Order textbox");
		addProductWithLoginPom.clickDeliveryMethodContinueBtn();
		screenShot.captureScreenShot("enter text");
	}
	
	@Test(priority=8)
	public void clickChkboxbtnTest(){
		addProductWithLoginPom.addcommentYourOrder("Order should be delivered safely");
		addProductWithLoginPom.clickCheckbox();
		System.out.println("I have read and agree to the Terms & Conditions checkbox should be selected");
		screenShot.captureScreenShot("clicked on chkecbox");
		
	}
	@Test(priority=9)
	public void clickPaymentBtnTest(){
		addProductWithLoginPom.clickPaymentBtn();
		System.out.println("Product Confirmation page should get displayed");
		
	}
	
	@Test(priority=10)
	public void clickConfirmOrderTest(){
		addProductWithLoginPom.clickConfirmBtn();
		System.out.println("clicked on confirm order");
		screenShot.captureScreenShot("clicked on confirm order");
		
	}
	
	@Test(priority=11)
	public void validateconfirmMsgTest(){
		String expectedtext="Your order has been successfully processed!";
		assertEquals(addProductWithLoginPom.validateconfirmedmsg(),expectedtext);
		System.out.println("Message Should get displayed on the screen");
		screenShot.captureScreenShot("validated product details should get removed from cart");
		
	}
	
	

}
