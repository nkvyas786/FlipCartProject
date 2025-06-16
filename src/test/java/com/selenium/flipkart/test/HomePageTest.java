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

    public HomePageTest() throws IOException {
        super();
    }

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

    @Test(priority =2)
    public void verifyHomepageNumberOfLinks(){
        homePage.homePageLink();
    }

    @Test(priority =3)
    public void verifyHomePageNumberOfImgs(){
        homePage.homePageAllImages();

    }
    @Test(priority =4)
    public void clickOnDSLR() throws InterruptedException {
        homePage.selectDSLR();

    }

    @Test(priority =5)
    public void getAllMobileWithSortedPrice() throws InterruptedException {
        homePage.getMinAndMaxMobilePrice();
        Thread.sleep(2000);
    }

    @Test(priority =6)
    public void selectRangeSlider() throws InterruptedException {
        homePage.setPriceRange();

    }



    @AfterMethod
    public void closeBrw() {
        if (driver != null){
            driver.quit();
        } else{
            System.out.println("Driver is not initialized.");
        }}}
