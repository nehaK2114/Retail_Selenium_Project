package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyOrderLinkPOM {
	private WebDriver driver; 
	private Actions actions;
	
	 public MyOrderLinkPOM(WebDriver driver) {
			super();
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account']")
	   private WebElement menubtn;
	   
	   @FindBy(xpath="//li[@class='tb_link tb_menu_system_account_login']")
	   private WebElement account;
	   @FindBy(xpath="//input[@id='input-email']")
		private WebElement emailId; 
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(xpath="//input[@value='Login']")
		private WebElement loginBtn; 
		
		@FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account tb_selected']")
		private WebElement usericon;
		
		@FindBy(xpath="//i[@class='fa fa-shopping-cart']//ancestor::a")
		private WebElement myOrderLink;
		
		//@FindBy(xpath="//span[@class='tb_icon']//following::i[@class='fa fa-shopping-cart']")
		@FindBy(xpath="//td[@class='text-right']//a[@class='btn btn-default tb_no_text']")
		private WebElement viewIcon;
		
		public void clickMenuBtn() {
			actions=new Actions(driver);
			actions.moveToElement(menubtn).moveToElement(account).click().build().perform();
			
		}
		public void sendEmailId(String email) {
			this.emailId.sendKeys(email);
		}
		
		public void sendPassword(String password) {
			this.password.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		
		public void clickMyOrderLink() {
			actions=new Actions(driver);
			actions.moveToElement(usericon).moveToElement(myOrderLink).click().build().perform();
			
		}
		
		public void clickViewIcon() {
//			WebDriverWait wait=new WebDriverWait(driver,20);
//			wait.until(ExpectedConditions.elementToBeClickable(viewIcon));
			this.viewIcon.click(); 
			
		}
		
		public String validateMyOderLink(){
			return driver.getTitle();
			
		
		}
}
