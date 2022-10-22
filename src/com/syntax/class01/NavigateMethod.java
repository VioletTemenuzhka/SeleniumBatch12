package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();//launching the browser once
        driver.get("https://www.facebook.com/");//method to navigate to an url
        driver.navigate().to("https://www.google.com/");//another method to navigate to an url
        //browser uses the same tab to navigate to different url
        driver.navigate().back();//navigate back
        driver.navigate().forward();//navigate forward
        //pause the execution for 2 secs(2000 milliseconds
       Thread.sleep(2000); // this will not being used for real, it is just for showing right now the refreshing
                                // to jump over this compiler error  hover over the error and click
                                // "Add exception to method signature"
                                // throws InterruptedException will show in the main method header
        driver.navigate().refresh();//refresh the webpage
        // driver.close();// closing the current/active tab
        driver.quit();// closing the whole browser


    }
}
