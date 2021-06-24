package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	WebElement PlaceOrderbtn;
	
	@FindBy(xpath="//div[@class='_2FxGQ6']")
	WebElement ConditionPopup;
	
	@FindBy(xpath="//button[@class='_2KpZ6l LFthfI _210eMQ']")
	WebElement PopContibtn;

	@FindBy(xpath="//div[@class='_1-GQyH']/parent::div[@class='_1AtVbE col-3-12']/parent::div[@class='_1YokD2 _2GoDe3 col-12-12']/following-sibling::div[@class='_1AtVbE col-12-12']")
	WebElement MycrtSec;
	
	//div[@class='_1AtVbE col-12-12']/child::div[@class='zab8Yh _10k93p']/child::div[@class='_2nQDXZ']/a
	@FindBy(xpath="//div[@class='_1-GQyH']/parent::div[@class='_1AtVbE col-12-12']/following-sibling::div[@class='_1AtVbE col-12-12']")
	WebElement SavefrLater;
	
	
	
  public CartPage() {
	  PageFactory.initElements(driver, this);
  }
  
  public void ClickPlace() {
	  PlaceOrderbtn.click();
	  
  }  
	public boolean PopupDisplayed() {
		return ConditionPopup.isDisplayed();
	  }
	  
	public OrderConfirmationPage tapOnContinue() {
		PopContibtn.click();
		return new OrderConfirmationPage();
	}
  
	public String validateTitle() {
		return driver.getTitle();
	}
}