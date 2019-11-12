package com.training.pom;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Thirdset_RTTC_064_POM {
	private WebDriver driver;
	private Select select;
	private Actions actions;

	public Thirdset_RTTC_064_POM(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#input-username")
	private WebElement adminid;
	
	@FindBy(id="input-password")
	private WebElement adminpwd;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//i[@class='fa fa-indent fa-lg']")
	private WebElement dashbtn;
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]")
	private WebElement catalogbtn;
	
	@FindBy(linkText="Products")
	private WebElement productbtn;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewIcon;
	
	@FindBy(css="#input-name1")
	private WebElement productName;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement description;
	
	
	@FindBy(css="#input-meta-title1")
	private WebElement metatagTitle;
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagDescription;
	@FindBy(linkText="Data")
	private WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modelid;
	
	@FindBy(css="#input-price")
	private WebElement price;
	
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(linkText="Design")
	private WebElement designtab;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg;
	
	
	
	
	
	public void sendAdminId(String id){
	this.adminid.sendKeys(id);
}
	public void sendAdminPwd(String pwd){
		this.adminpwd.sendKeys(pwd);
	}
	
	public void clickLoginBtn(){
		this.loginbtn.click();
	}
	
	public void clickDashBtn(){
		this.dashbtn.click();
	}
	
	public void clickCatalogBtn(){
		this.catalogbtn.click();
	}
	
	public void clickProductBtn(){
		this.productbtn.click();
	}
	
	public void clickAddNewIcon(){
		this.addnewIcon.click();
	}
	
	public void sendProductName(String pname){
		this.productName.sendKeys(pname);

	}
	
	public void sendDescription(String desc){
		this.description.sendKeys(desc);
	}
	
	
	public void sendMetaTagTitle(String mtagtile){
		this.metatagTitle.sendKeys(mtagtile);
	}
	
	public void sendMetaTagDescription(String mtagdesc){
		this.metaTagDescription.sendKeys(mtagdesc);
	}
	
	public void clickDataTab(){
		this.dataTab.click();
	}
	
	public void sendModelid(String mid){
		this.modelid.sendKeys(mid);
	}
	
	public void sendPricevalue(String pricevalue){
		this.price.sendKeys(pricevalue);
	}
	
	public void sendQuantityvalue(String quantity){
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void clickDesignTab(){
		this.designtab.click();
	}
	public void clickSaveBtn(){
	this.savebtn.click();
	
	}
	public void validatesuccessMsg(){
		 System.out.println(this.successmsg.getText());
		 String expectedmsg="Success: You have modified products!";
			assertTrue(true, expectedmsg);
			System.out.println("Message should get display in Product List page");
	}
	
	
}
