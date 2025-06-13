package com.flipkart.selenium.pages;

import com.flipkart.selenium.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class HomePage extends TestBase {


	@FindBy(tagName = "a")
 	List<WebElement> links;

	@FindBy(tagName="a")
	List<WebElement> allImgs;

	@FindBy(xpath = "//span[@class='_1XjE3T']/span[normalize-space()='Electronics']")
	WebElement electronicsOption;

	@FindBy(xpath="//a[normalize-space()='Cameras & Accessories']")
	WebElement camerasOption;

	@FindBy(xpath = "//a[normalize-space()='DSLR & Mirrorless']")
	WebElement dSLROption;

	@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@class='Nx9bqj _4b5DiR']")
	List<WebElement> mobilePriceElement;

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

	public void selectDSLR() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(electronicsOption).build().perform();
		Thread.sleep(1000);
		actions.moveToElement(camerasOption).build().perform();
		Thread.sleep(1000);
		actions.moveToElement(dSLROption).click().build().perform();
		Thread.sleep(1000);
		dSLROption.click();
		Thread.sleep(2000);
	}
	

	public void getMinAndMaxMobilePrice(){
		searchBox.sendKeys("Mobile", Keys.ENTER);

		for(int i= 0; i<=mobilePriceElement.size()-1;i++ ){

			System.out.println((mobilePriceElement.get(i).getText().replaceAll("₹", "")));

		}
		String [] prices = {"18,999" ,"26,999" ,"6,499" ,"19,999" ,"1,29,999" ,"28,999" ,"1,140" , "1,899" ,"13,999" , "6,249" ,"1,53,999" ,"1,29,999" ,"5,999" ,"13,999" ,"1,799" ,"899" ,"1,29,999" ,"1,17,999" ,"7,699" ,"6,499" ,"1,29,999" ,"1,17,999" ,"6,999" ,"899"};
		Arrays.sort(prices);
		System.out.println(Arrays.toString(prices));
        String minPrices = prices[0] ;
        String maxPrices = prices[prices.length-1];
        System.out.println("Minimum price is : "+minPrices);
        System.out.println("Maximum price is : "+maxPrices);





	}




	}
	
	
	

