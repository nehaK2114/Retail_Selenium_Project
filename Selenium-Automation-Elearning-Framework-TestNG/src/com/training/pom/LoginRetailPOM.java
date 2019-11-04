package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRetailPOM {
private WebDriver driver; 
private Actions actions;
	
	 public LoginRetailPOM(WebDriver driver) {
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
	
	public String validateRegisterPOMMsg(){
		return driver.getTitle();
	}

}
