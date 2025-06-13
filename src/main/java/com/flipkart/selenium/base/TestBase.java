package com.flipkart.selenium.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.flipkart.selenium.utils.TestUtil;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    protected static Logger logger;




    public TestBase(){
    try {
        prop = new Properties();
        FileInputStream fis;
        fis = new FileInputStream("/Users/nivivyas/Documents/FlipCartProject/src/main/java/com/flipkart/selenium/config/GlobalData.properties");
        prop.load(fis);
        logger = Logger.getLogger(TestBase.class.getName());
        PropertyConfigurator.configure("/Users/nivivyas/Documents/FlipCartProject/src/main/java/com/flipkart/selenium/config/log4j.properties");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @Test
    public static void initialization() {
//            prop = new Properties();
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//                    + "//src//main//java//resources//GlobalData.properties");
//            prop.load(fis);
        //String browserName = prop.getProperty("browser");


        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("*******************Chrome Browser Launched************************");
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
            }
            else if (browserName.equalsIgnoreCase("edge")) {
            }

//       // headless browser setup
//        ChromeOptions options = new ChromeOptions();
//        WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver(options);
//         options.addArguments("headless");

        //driver.manage().window().setSize(new Dimension(1920, 1080));


//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Navigation to App URL
        driver.navigate().to(prop.getProperty("url"));
        //driver.get(prop.getProperty("url"));
        //driver.navigate().to("https://rahulshettyacademy.com/client");
        //driver.get("https://rahulshettyacademy.com/client");
    }
}


