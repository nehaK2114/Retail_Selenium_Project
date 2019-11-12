package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ThirdSet_RTTC_062_POM {
	private WebDriver driver; 
	private Actions actions;
	private Select select; 
	public ThirdSet_RTTC_062_POM(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account']")
	   private WebElement menubtn;
	   
	   @FindBy(xpath="//li[@class='tb_link tb_menu_system_account_login']")
	   private WebElement account;
	   
	   @FindBy(xpath="//a[@href='http://retailm1.upskills.in/account/register']")
	   private WebElement register;
		
	   @FindBy(css="#input-firstname")
	   private WebElement firstname;
	   
	   @FindBy(css="#input-lastname")
	   private WebElement lastname;
	   
	   @FindBy(css="#input-email")
	   private WebElement email;
	   
	   @FindBy(css="input.form-control[placeholder='Telephone']")
	   private WebElement telephone;
	   
	   @FindBy(name="address_1")
	   private WebElement address1;
	   
	   @FindBy(name="address_2")
	   private WebElement address2;
	   
	   @FindBy(id="input-city")
	   private WebElement city;
	   
	   @FindBy(name="postcode")
	   private WebElement postalcode;
	   
	   @FindBy(id="input-country")
	   private WebElement country;
	   
	   @FindBy(css="#input-zone")
	   private WebElement region;
	   
	   @FindBy(xpath="//input[contains(@name,'password')]")
	   private WebElement password;
	   
	   @FindBy(xpath="//input[contains(@placeholder,'Password Confirm')]")
	   private WebElement confirmpwd;
	   
	   @FindBy(xpath="//label[contains(@class,'radio-inline')]//child::input[@type='radio' and @checked='checked']")
	   private WebElement confirmRadiobtn;
	   
	   @FindBy(xpath="//input[@name='agree']")
	   private WebElement confirmCheckbox;
	   
	   @FindBy(xpath="//input[contains(@type,'submit')]")
	   private WebElement continuefield;
		
	   @FindBy(xpath="//span[contains(text(),'LOGOUT')]")
	   private WebElement logout;
		
		public void clickMenuBtn() {
			actions=new Actions(driver);
			actions.moveToElement(menubtn).moveToElement(account).click().build().perform();
			
		}
		
		public void clickRegisterBtn() {
			this.register.click();
		}
		
		public void sendFirstname(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}
		public void sendLasttname(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
		}
		public void sendEmail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		}
		public void sendTelephone(String phone) {
			this.telephone.clear();
			this.telephone.sendKeys(phone);
		}
		
		public void sendAddress1(String address1) {
			this.address1.clear();
			this.address1.sendKeys(address1);
		}
		
		public void sendAddress2(String address2) {
			this.address2.clear();
			this.address2.sendKeys(address2);
		}
		
		public void sendCity(String city) {
			this.city.clear();
			this.city.sendKeys(city);
		}
		
		public void sendPostalCode(String code) {
			this.postalcode.clear();
			this.postalcode.sendKeys(code);
		}
		
		public void sendCountry(String country1) {
			select=new Select(country);
			select.selectByVisibleText(country1);
			
			
		}
		
		public void sendRegion(String zone) {
			select=new Select(region);
			select.selectByVisibleText(zone);
		}
		
		public void sendPassword(String pwd) {
			this.password.clear();
			this.password.sendKeys(pwd);
		}
		
		public void sendConfirmPassword(String cpwd) {
			this.confirmpwd.clear();
			this.confirmpwd.sendKeys(cpwd);
		}
		
		public void clickRediaoBtn() {
			this.confirmRadiobtn.click(); 
		}
		public void clickCheckbox() {
			this.confirmCheckbox.click(); 
		}
		public void clickContinueButton() {
			this.continuefield.click(); 
		}
		
		public void clickLogoutButton() {
			actions=new Actions(driver);
			actions.moveToElement(menubtn).moveToElement(logout).click().build().perform();
		}
		
		public String validateRegisterPOMMsg(){
			return driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
		}
		
}
