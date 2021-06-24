package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath= "//a[@class='_1_3w1N']")
	WebElement PreLoginButton;
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement EmailField;
	
	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement PasswordField;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement SubmitBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
		}
	
	public String ValidateloginTitle() {
		return driver.getTitle();
	}
	//String Logintext =	loginPage.LoginPopText.getText();
		//System.out.println(Logintext);
	//}
		
		public HomePage login(String un, String pw) {
			try{
				EmailField.sendKeys(un);
				Thread.sleep(2000);
				PasswordField.sendKeys(pw);
				Thread.sleep(3000);
				SubmitBtn.click();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new HomePage();
			
		
		}
	}
	
			
	

