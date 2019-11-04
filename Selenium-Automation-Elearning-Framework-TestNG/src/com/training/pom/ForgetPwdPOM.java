package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPwdPOM {
	
private WebDriver driver;
	
	public ForgetPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account']")
		private WebElement menubtn;
	
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailId; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Forgotten Password")
	private WebElement fpwd;
	
	@FindBy(xpath="//input[contains(@type,'submit')]")
	private WebElement submitbtn;
	
	public void clickMenuBtn() {
		this.menubtn.click();
		
	}
	public void sendEmailId(String email) {
		this.emailId.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.submitbtn.click(); 
	}
	
	public void clickForgotPwdLink(){
		this.fpwd.click();
	}
	public void clickSubmitBtn(){
		this.submitbtn.click();
	}
	
	public String validateForgetPwdMsg(){
		String msg=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		return msg;
	}
	
	public String validateMsgafterrest(){
		String msg=driver.findElement(By.xpath("//i[@class='fa fa-check-circle']//parent::div")).getText();
		return msg;
	}

}
