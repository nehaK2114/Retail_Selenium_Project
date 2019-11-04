package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPOM {
	private WebDriver driver; 
	private Actions actions;
		
		 public  EditPOM(WebDriver driver) {
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
		
		@FindBy(linkText="Edit your account information")
		private WebElement editLink;
		
		@FindBy(css="#input-firstname")
		private WebElement firstName;
		@FindBy(css="#input-lastname")
		private WebElement lastName;
		@FindBy(css="#input-email")
		private WebElement email;
		@FindBy(css="input.form-control[placeholder='Telephone']")
		private WebElement phone;
		@FindBy(xpath="//input[contains(@value,'Continue')]")
		private WebElement continuebtn;
		@FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement actualMsg;
		
		
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
		
		public void clickEditLink(){
			this.editLink.click();
		}
		
		public void sendFirstName(String fname) {
			this.firstName.clear();
			this.firstName.sendKeys(fname);
		}
		
		public void sendLastName(String lname) {
			this.lastName.clear();
			this.lastName.sendKeys(lname);
		}
		
		public void sendEmail(String emailId) {
			this.email.clear();
			this.email.sendKeys(emailId);
		}
		
		public void sendPhone(String ph) {
			this.phone.clear();
			this.phone.sendKeys(ph);
		}
		public void clickContinue(){
			this.continuebtn.click();
		}
		public String validateEditTest(){
			return actualMsg.getText();
		}

}
