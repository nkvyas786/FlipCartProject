package com.flipkart.selenium.pages;

import com.flipkart.selenium.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {


	@FindBy(tagName = "a")
 	List<WebElement> links;

	@FindBy(tagName="a")
	List<WebElement> allImgs;

	@FindBy(xpath = "//span[@class='_1XjE3T']/span[normalize-space()='Electronics']")
	WebElement electronicsOption;

	public HomePage() {
		PageFactory.initElements(driver, this);
		}

	public String homeGetTitle(){
		return driver.getTitle();
	}

	public void homePageLink(){
		for (WebElement link : links) {
				System.out.println(link.getText());
			}
	}

	public void homePageAllImages(){
		for(WebElement img:allImgs ){
			System.out.println(img.getSize());
			System.out.println(img.getText());
		}
	}
	

	
	
	
	
}
