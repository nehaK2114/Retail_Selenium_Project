package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductWithLoginPOM {
	private WebDriver driver; 
	private Actions actions;
	public AddProductWithLoginPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement homeLink;
	
	@FindBy(linkText="lacinia congue")
	private WebElement product;
	@FindBy(id="button-cart")
	private WebElement addToCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement cartIcon;
	
	@FindBy(linkText="View Cart")
	private WebElement viewCartbtn;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
private WebElement chkoutbtn;
	
	@FindBy(css="#button-payment-address")
	private WebElement continuebth;
	
	@FindBy(id="button-shipping-address")
	private WebElement deliverybtn;
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement commentArea;
	
	@FindBy(id="button-shipping-method")
	private WebElement deliverMethodbtn;
	
	@FindBy(xpath="//div[@id='collapse-payment-method']//textarea[@name='comment']")
	private WebElement paymentcommentArea;
	
	@FindBy(css="#button-payment-method")
	private WebElement paymentbtn;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	private WebElement chkbox;
	
	@FindBy(id="button-confirm")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//p[contains(text(),'Your order has been successfully processed!')]")
	private WebElement confirmedmsg;
	

	
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
	public void clickHomeLink(){
		this.homeLink.click();
	}
	public void clickProductBtn() {
		this.product.click(); 
	}
	public void clickAddtoCartBtn() {
		this.addToCart.click(); 
	}
	public void hoveroncartIcon(){
		actions=new Actions(driver);
		actions.moveToElement(cartIcon).build().perform();
		
	}
	public String validateCartMsg(){
		return driver.findElement(By.xpath(" //ul[@class='noty_cont noty_layout_topRight']//h3[1]")).getText();
		
		
	}
	public void clickViewCartBtn(){
		actions=new Actions(driver);
		actions.moveToElement(cartIcon).build().perform();
		actions.moveToElement(viewCartbtn).click().build().perform();
	}
	
	public void clickCheckoutBtn(){
		this.chkoutbtn.click();
	}
	
	public void clickContinueBtn() {
		this.continuebth.click(); 
	}
	public void clickDeliveryBtn() {
		this.deliverybtn.click(); 
	}
	
	public void enterComment(String text) {
		this.commentArea.sendKeys(text);
	}
	public void clickDeliveryMethodContinueBtn() {
		this.deliverMethodbtn.click(); 
	}
	public void clickPaymentBtn() {
		this.paymentbtn.click(); 
	}
	public void clickCheckbox(){
		WebDriverWait wait=(new WebDriverWait(driver,10));
		wait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
		
		}
	
	public void addcommentYourOrder(String ptext){
		this.paymentcommentArea.clear();
		this.paymentcommentArea.sendKeys(ptext);
	}
	
	public void clickConfirmBtn() {
		this.confirmBtn.click(); 
	}
	
	public String validateconfirmedmsg() {
		 return confirmedmsg.getText();
	}
	
	
}
