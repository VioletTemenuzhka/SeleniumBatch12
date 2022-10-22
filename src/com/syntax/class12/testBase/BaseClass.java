package com.syntax.class12.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    //create a variable of the driver
    public static WebDriver driver;
    /** Create:
     * method to open a browser
     * method to close a browser
     */

    /**
     * this method will navigate to a website by the given url --> it's called javadoc
     * javadoc is a description of what the following method is performing
     * @param url
     */

    public static void openWithSpecificUrl(String url){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * this method will quit an open browser
     */

    public static void tearDown(){
        //we set the iff condition with driver!=null, because during execution if something happened and driver=null,
        // we need to see where the error is and what happened
       if(driver != null){
           driver.quit();
       }
    }

}
