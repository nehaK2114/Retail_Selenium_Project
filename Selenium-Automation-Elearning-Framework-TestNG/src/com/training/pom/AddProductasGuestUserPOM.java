package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductasGuestUserPOM {
	
	private WebDriver driver;
	private Actions actions;
	private Select select;
	
	
	public  AddProductasGuestUserPOM(WebDriver driver){
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
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
	
	@FindBy(xpath="//input[@name='account' and @value='guest']")
	private WebElement radiobtn;
	
	@FindBy(css="#button-account")
	private WebElement accountbtn;
	
	@FindBy(id="input-payment-firstname")
	private WebElement guestFName;
	@FindBy(id="input-payment-lastname")
	private WebElement guestLName;
	@FindBy(id="input-payment-email")
	private WebElement guestEmail;
	@FindBy(id="input-payment-telephone")
	private WebElement guestPhone;
	@FindBy(id="input-payment-address-1")
	private WebElement guestAddress;
	@FindBy(id="input-payment-city")
	private WebElement guestCity;
	@FindBy(id="input-payment-country")
	private WebElement guestCountry;
	@FindBy(id="input-payment-zone")
	private WebElement guestRegion;
	@FindBy(xpath="//input[@name='shipping_address']")
	private WebElement chkbtn;
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement guestchkbtn;
	@FindBy(xpath="//div[@id='collapse-shipping-method']//textarea[@name='comment']")
	private WebElement commentArea;
	
	@FindBy(id="button-shipping-method")
	private WebElement deliverMethodbtn;
	
	@FindBy(xpath="//input[@name='payment_method']")
	private WebElement cashbtn;
	
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
	
	
	public void clickLinkBtn() {
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
	
	public void clickGuestAccountRadioBtn(){
		this.radiobtn.click();
		
	}
	
	public void clickContinueAccountBtn(){
		this.accountbtn.click();
	}
	
	public void sendGuestFirstname(String gfname){
		this.guestFName.sendKeys(gfname);
	}
	public void sendGuestLastname(String glname){
		this.guestLName.sendKeys(glname);
	}
	public void sendGuestEmail(String gemail){
		this.guestEmail.sendKeys(gemail);
	}
	public void sendGuestPhone(String gphone){
		this.guestPhone.sendKeys(gphone);
	}
	public void sendGuestAddress1(String gaddress1){
		this.guestAddress.sendKeys(gaddress1);
	}
	public void sendGuestCity(String gcity){
		this.guestCity.sendKeys(gcity);
	}
	public void sendGuestCountry(String gcountry){
	
		select=new Select(guestCountry);
		select.selectByVisibleText(gcountry);
	}
	public void sendGuestRegion(String gregion){
		select=new Select(guestRegion);
		select.selectByValue(gregion);
	}
	public void clickCheckboxBtn(){
		if(chkbtn.isSelected()){
			System.out.println("no action required");
		}
		else{
			chkbtn.click();
		}
	}
	
	public void clickGuestContinueBtn(){
		this.guestchkbtn.click();
	}
	public void enterComment(String text) {
		this.commentArea.sendKeys(text);
	}
	public void clickDeliveryMethodContinueBtn() {
		this.deliverMethodbtn.click(); 
	}
	public void clickCODBtn() {
		if(!cashbtn.isDisplayed()){
		cashbtn.click(); 
		}
		else{
			System.out.println("no action reqd");
		}
	}
	public void addcommentYourOrder(String ptext){
		this.paymentcommentArea.clear();
		this.paymentcommentArea.sendKeys(ptext);
	}
	public void clickPaymentBtn() {
		this.paymentbtn.click(); 
	}
	public void clickCheckbox(){
		WebDriverWait wait=(new WebDriverWait(driver,10));
		wait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
		
		}
	
	public void clickConfirmBtn() {
		this.confirmBtn.click();
		
	}
	
	public String validateconfirmedmsg() {
		 return confirmedmsg.getText();
	}
	

}
