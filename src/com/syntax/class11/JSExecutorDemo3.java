package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo3 {
    public static String url = "https://www.google.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //open it on the first tab
        //if first open a new tab and then navigate to the url, it will open in the first tab, because the focus is on the first one
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open('https://www.amazon.com/');"); //opens a new tab and navigates to amazon.com
        driver.get(url);

        //if first navigate to the url and then open a new tab, the url will be in the first tab
       /* JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open('https://www.amazon.com/');");

        */

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("ewfkerghdfcxjkf");
        //We were able to send the keys to google, because the focus of Selenium is still on google.com
        //even though visually we see amazon.com


    }

}
