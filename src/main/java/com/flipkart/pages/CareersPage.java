package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class CareersPage extends TestBase {
		
	@FindBy(xpath = "//img[@src='images/logo.png']")
	WebElement CareersLogo;
	
	public CareersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateCareersTitle() {
		return driver.getTitle();
		}

	}

