package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductWithoutLoginPom {
	private WebDriver driver;
	private Actions actions;
	
	
	public  AddProductWithoutLoginPom(WebDriver driver){
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
	
	public String LoginpageDisplayed(){
		return driver.getTitle();
	}
	
		
	}

