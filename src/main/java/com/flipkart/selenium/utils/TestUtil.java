package com.flipkart.selenium.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class TestUtil {

    public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
    public static Duration IMPLICIT_WAIT = Duration.ofSeconds(10);

    static WebDriver driver;


    public void waitForElement(By findBy){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public static void report(){

        ExtentReportUtility.config();

    }

    public void actionUtility(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("Electronics"))).build().perform();

    }


    public  void excelRead() throws IOException {

        File file = new File("C:\\Users\\User\\IdeaProjects\\AutomationFramework\\src\\main\\resources\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("workbook");


    }

    public static void scrollPageDown(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");


    }


    public static void scrollPageUp(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1500)", "");


    }

    @Test(dataProvider = "data")
    public void test(String data) {
        Assert.assertEquals(data, "data1"); // Example assertion
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                new Object[] { "" },
                new Object[] { "data2" }
        };
    }

    public static void getHTTPResponseStatus(){
//get list of elements with anchor tag
        List<WebElement> l = driver.findElements(By.tagName("a"));
        //iterate links
        for(int i=0; i<l.size(); i++) {
            WebElement e = l.get(i);
            //get URL of links with getAttribute()
            String u = e.getAttribute("href");
            // to catch MalFormedURLException
            try{
                //object of URL class
                URL link = new URL(u);
                // establish connection URL object
                HttpURLConnection c = (HttpURLConnection)link.openConnection();
                //have timeout
                c.setConnectTimeout(1000);
                // connection began
                c.connect();
                //getResponseCode() to obtain response code
                if(c.getResponseCode()== 200) {
                    System.out.println(u+" − "+ c.getResponseMessage());
                }
                if(c.getResponseCode()== 404) {
                    System.out.println(u+" − "+c.getResponseMessage());
                }
            }
            catch (Exception ex) {
            }
        }


    }
}
