package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@class='exehdJ' and text()='Nivi']")
	WebElement LoggedUN;
	
	@FindBy(xpath= "//a[@class='_1arVWX' and text()='Careers']")
	WebElement CarrersLink;
	
	@FindBy(xpath="//div[@class='KK-o3G']")
	WebElement CartLink;
	
	
	public HomePage() {
	PageFactory.initElements(driver, this);	
		}
	
	public CareersPage TapOnCareersLink() {
		CarrersLink.click();
		return new CareersPage();
	}
	public CartPage NavigateToCart() {
		CartLink.click();
		return new CartPage();
	}
	
	
	
	
}
