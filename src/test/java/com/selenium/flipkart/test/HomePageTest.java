package com.selenium.flipkart.test;
import com.flipkart.selenium.base.TestBase;
import com.flipkart.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePage homePage;

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
    }

    @Test(priority  =1)
    public void verifyHomePageTitle(){
        String actualTitle = homePage.homeGetTitle();
        System.out.println("Title of HomePage is: " +actualTitle);
        Assert.assertEquals(actualTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "Title is not matching");
    }

    @Test
    public void verifyHomepageNumberOfLinks(){
        homePage.homePageLink();
    }

    @Test
    public void verifyHomePageNumberOfImgs(){
        homePage.homePageAllImages();

    }






    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
        } else{
            System.out.println("Driver is not initialized.");
        }}}
