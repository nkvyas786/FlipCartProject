package com.Cart.Test;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.CartPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.OrderConfirmationPage;

public class CartTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	OrderConfirmationPage orderConfirmPage;
	
	public CartTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	@Test(priority=1)
	public void NavigateToCartSc() {
		try {
			cartPage=homePage.NavigateToCart();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	@Test(priority=2)
	public void ValidatinTitle() {
		try {cartPage=homePage.NavigateToCart();
			Thread.sleep(3000);
			String title1 = cartPage.validateTitle();
			Assert.assertTrue(true, "Shopping Cart | Flipkart.com");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=3)
	public void PlaceOrderNavigation() {
		try {
			cartPage=homePage.NavigateToCart();
			Thread.sleep(3000);
			cartPage.ClickPlace();
			
			Set<String>wind=driver.getWindowHandles();
			
			if(wind.size()>1) {
				driver.switchTo().window("give Name");
				if
				(cartPage.PopupDisplayed()==true){
				     cartPage.tapOnContinue();
				}}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchElementException ne) {	
		}}
	@Test(priority=1)
	public void getMyCartListItems() {
		try {cartPage=homePage.NavigateToCart();
		Thread.sleep(3000);
			List<WebElement>list = driver.findElements(By.xpath("//div[@class='_1-GQyH']/parent::div[@class='_1AtVbE col-3-12']/parent::div[@class='_1YokD2 _2GoDe3 col-12-12']/following-sibling::div[@class='_1AtVbE col-12-12']"));
			for(WebElement listiTems: list  ) {
				System.out.println(listiTems.getText());
				System.out.println();
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchElementException ne) {	
		}
		
	}
	
	@Test(priority=0)
	public void getLinksofItems() {
		try {
			cartPage=homePage.NavigateToCart();
			Thread.sleep(3000);
			List<WebElement>Linkslist = driver.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']/child::div[@class='zab8Yh _10k93p']/child::div[@class='_2nQDXZ']/a"));
			for(WebElement linkTems: Linkslist  ) {
				System.out.println(linkTems.getText());
				System.out.println(linkTems.getAttribute("href"));
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchElementException ne) {	
		}
		
	}

	
	//div[@class='_1AtVbE col-12-12']/child::div[@class='zab8Yh _10k93p']/child::div[@class='_2nQDXZ']/a
	@AfterMethod
	public void closeBrw() {
		driver.quit();
	} 

}
