package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {
    /* Navigate to http://accounts.google.com/signup
        click on Help Link
        switch between tabs
     */
    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle();//returns the ID of the current tab; get window handle for the main page
        System.out.println(mainPageHandle);

        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles();//store all the handles in a set
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();//have an iterator in order to iterate through the handles
        mainPageHandle = it.next();//take the first step and assigning the main handle my next step.
        //Set can start from everywhere
        String childHandle = it.next();//take the next step and have a child handle
        System.out.println(childHandle);
        Thread.sleep(3000);
        driver.switchTo().window(childHandle);

        driver.close(); //it closed the main page, because when we got the url, than click on "Help", new tab opened, but
        //Selenium focus never switched from the main page. So when call .close() method, it'll close the current tab ON FOCUS
        helpLink.click(); //NoSuchWindowException: no such window: target window already closed
        //To have it available, switch the focus to main page
        driver.switchTo().window(mainPageHandle);
        helpLink.click();

        //driver.quit();




    }
}
