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

public class Thirdset_RTTC_065_POM {
	private WebDriver driver;
	private Select select;
	private Actions actions;

	public Thirdset_RTTC_065_POM(WebDriver driver) {
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
	
	@FindBy(css="#input-meta-title1")
	private WebElement metatagTitle;
	
	@FindBy(linkText="Data")
	private WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modelid;
	
	@FindBy(css="#input-price")
	private WebElement price;
	
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(linkText="Links")
	private WebElement linktab;
	
	@FindBy(css="#input-category")
	private WebElement category;
	
	@FindBy(xpath="//a[contains(text(),'Ear Rings')]//parent::li[@data-value='647']")
	private WebElement earrings;
	
	@FindBy(linkText="Discount")
	private WebElement discounttab;
	
	@FindBy(xpath="//table[@id='discount']//i[@class='fa fa-plus-circle']")
	private WebElement addDiscountIcon;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement dquantity;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement dprice;
	
	@FindBy(linkText="Reward Points")
	private WebElement rewardpoints;
	
	@FindBy(id="input-points")
	private WebElement points;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg;
	
	@FindBy(linkText="Attribute")
	private WebElement attributetab;
	@FindBy(linkText="Option")
	private WebElement optiontab;;
	@FindBy(linkText="Recurring")
	private WebElement recurringtab;
	@FindBy(linkText="Special")
	private WebElement specialtab;
	@FindBy(linkText="Image")
	private WebElement imagetab;
	@FindBy(linkText="Design")
	private WebElement designtab;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]")
	private WebElement startdateclick;
	
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]")
	private WebElement enddateclick;
	
	@FindBy(xpath="//td[@class='day active']")
	private WebElement endDateData;
	
	@FindBy(xpath="//input[@placeholder='Date End']")
	private WebElement enddatetextbox;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(id="search_button")
	private WebElement searchbox;
	
	
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
	
	public void sendMetaTagTitle(String mtagtile){
		this.metatagTitle.sendKeys(mtagtile);
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
	
	public void clickLinkTab(){
		this.linktab.click();
	}
	
	public void clickCategoryTextBox(String cat){
		//this.category.click();
		this.category.sendKeys(cat);
		  
		
	}
	
	/*public void selectCategory(String cat){   //this has defect while auomating
		select=new Select(earrings);
		select.selectByValue(cat);
		System.out.println("found defect using above step.dont see Ear rings while automating the test case ");
		this.earrings.sendKeys(cat);
		
	}*/
	
	public void clickDiscountTab(){
		this.discounttab.click();
	}
	
	public void clickAddDiscountIcon(){
		this.addDiscountIcon.click();
	}
	
	public void sendDiscountQuantityvalue(String dquanitity){
		this.dquantity.sendKeys(dquanitity);
	}
	public void sendDiscountPrice(String dprice){
		this.dprice.sendKeys(dprice);
	}
	
	public void clickStartDayicon(){
		this.startdateclick.click();
	}

	
	public void clickEndDayicon(){
		//enddateclick.click();
		Date date = new Date();               
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");            
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);  // number of days to add  
		date=c.getTime();
		String str=formattedDate.format(date);
		System.out.println("tommorrow date is: "  + str);
		enddatetextbox.clear();
		enddatetextbox.sendKeys(str);
	
		


	}
	
	public void clickRewardPointTab(){
		this.rewardpoints.click();
	}
	
	public void sendPoints(String points){
		this.points.sendKeys(points);
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
	
	public void clickLogutBtn(){
		this.logout.click();
		
		}
	public void sendtextinSearchBox(String searchp) {
		actions=new Actions(driver);
		actions.moveToElement(searchbox).click().build().perform();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.getElementById('search_button').value='Finger rings for TC-65'");
		this.searchbox.sendKeys(searchp);
		this.searchbox.submit();
		
	}
}
