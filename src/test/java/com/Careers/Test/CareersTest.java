package com.Careers.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Login.Test.LoginPageTest;
import com.flipkart.base.TestBase;
import com.flipkart.pages.CareersPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;

public class CareersTest extends TestBase{
	
	LoginPage loginPage;
	CareersPage careersPage;
	HomePage homePage;
	
	public CareersTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test(priority=1)
	public void NavigateCareers() {
		try {
         careersPage=homePage.TapOnCareersLink();
		 Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=2)
    public void validateCareersTitle() {
		try {   
			careersPage=homePage.TapOnCareersLink();
		    Thread.sleep(4000);
		    String title1 =	careersPage.validateCareersTitle();
		    Assert.assertEquals(title1, "Flipkart - Careers");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@AfterMethod
	public void closeBrw() {
		driver.quit();
	}
}
