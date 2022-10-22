package com.syntax.seleniumReview06.POM.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    /**
     * open the browser and navigate to specific url
     * @param url
     */
    public static void openWithSpecificUrl(String url){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public static void tearDown(){

        if(driver != null){
            driver.quit();
        }

    }
}
