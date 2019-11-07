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
import com.training.pom.AddProductasGuestUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import static org.testng.Assert.assertEquals;

public class AddProductAsGuestUserTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static AddProductasGuestUserPOM addProductasGuestUserPom;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addProductasGuestUserPom=new AddProductasGuestUserPOM(driver);
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
		addProductasGuestUserPom.clickLinkBtn();
		addProductasGuestUserPom.clickAddtoCartBtn();
		addProductasGuestUserPom.hoveroncartIcon();
	}
	
	
	
	@Test(priority=1)
	public void validateCartMsgTest(){
		
		System.out.println(addProductasGuestUserPom.validateCartMsg());
		screenShot.captureScreenShot("Added product as a guest User");
		
	}
	@Test(priority=2)
	public void clickViewCartBtnTest(){
		addProductasGuestUserPom.clickViewCartBtn();
		System.out.println("Product details containing Image, Product Name, Model, Quantity, Unit Price & Total should get displayed");
		screenShot.captureScreenShot("Clicked on View Cart as a guest User");
	}
	
	@Test(priority=3)
	public void clickChkoutBtnTest(){
		addProductasGuestUserPom.clickCheckoutBtn();
		screenShot.captureScreenShot("Clicked on Checkout as a guest User");
		
	}
	
	@Test(priority=4)
	public void clickGuestAccountRadioBtnTest() throws Exception{
		addProductasGuestUserPom.clickGuestAccountRadioBtn();
		System.out.println("Guest Radio button should get selected");
		screenShot.captureScreenShot("Clicked on radio btn");
		
	}

	@Test(priority=5)
	public void clickContinueAccountBtnTest(){
		addProductasGuestUserPom.clickContinueAccountBtn();
		System.out.println("'Your Personal Details' and 'Your Address' should get displayed");
		screenShot.captureScreenShot("Clicked on next continue btn");
		
	}

	@Test(priority=6)
	public void enterguestDetailsTest(){
		addProductasGuestUserPom.sendGuestFirstname("Neha");
		addProductasGuestUserPom.sendGuestLastname("Kumari");
		addProductasGuestUserPom.sendGuestEmail("nehavivz21@gmail.com");
		addProductasGuestUserPom.sendGuestPhone("9876543212");
		addProductasGuestUserPom.sendGuestAddress1("BTM Layout");
		addProductasGuestUserPom.sendGuestCity("Bangalore");
		addProductasGuestUserPom.sendGuestCountry("India");
		addProductasGuestUserPom.sendGuestRegion("1489");
		addProductasGuestUserPom.clickCheckboxBtn();
		System.out.println("checkboc already selected");
		addProductasGuestUserPom.clickGuestContinueBtn();
		System.out.println("'Your Personal Details' and 'Your Address' should get displayed");
		screenShot.captureScreenShot("Added guest user details");
		
	}
	@Test(priority=7)
	public void enterCommenttextTest(){
		
		addProductasGuestUserPom.enterComment("This product is nice");
		System.out.println("entered credentials should get displayed in Add Comments About Your Order textbox");
		addProductasGuestUserPom.clickDeliveryMethodContinueBtn();
		screenShot.captureScreenShot("enter text");
	}
	
	
	@Test(priority=8)
	public void clickChkboxbtnTest(){
		addProductasGuestUserPom.addcommentYourOrder("the product is nice");
		addProductasGuestUserPom.clickCODBtn();  //There is a bug in application hence the below test is failing.screen shot is attached
		addProductasGuestUserPom.clickCheckbox();
		System.out.println("I have read and agree to the Terms & Conditions checkbox should be selected");
		screenShot.captureScreenShot("Defect looged:-Cash ON deliver is not available");
		
	}
	@Test(priority=9)
	public void clickPaymentBtnTest(){
		addProductasGuestUserPom.clickPaymentBtn();
		
		System.out.println("Product Confirmation page should get displayed");
		screenShot.captureScreenShot("clicked on Payment continue button");
		
	}
	
	@Test(priority=10)
	public void clickConfirmOrderTest(){
		
		addProductasGuestUserPom.clickConfirmBtn();
		System.out.println("clicked on confirm order");
		screenShot.captureScreenShot("clicked on confirm order");
		
	}
	
	@Test(priority=11)
	public void validateconfirmMsgTest(){
		String expectedtext="Your order has been successfully processed!";
		assertEquals(addProductasGuestUserPom.validateconfirmedmsg(),expectedtext);
		System.out.println("Message Should get displayed on the screen");
		screenShot.captureScreenShot("validated product details should get removed from cart");
		
	}
	

}
