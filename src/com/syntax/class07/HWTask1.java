package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HWTask1 {
    /* Go to https://demoqa.com/browser-windows
    click on New Tab and print the text from new tab in the console
    click on New Window and print the text from new window in the console
    click on New Window Message and print the text from new window in the console
    Verify (compare) the titles for each page
    Print out the title of the all pages
     */
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPageHandle = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        WebElement newWindowMsgButton = driver.findElement(By.id("messageWindowButton"));
        newTabButton.click();
        newWindowButton.click();
        newWindowMsgButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String handle = it.next();
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);
                WebElement linkText = driver.findElement(By.xpath("//body"));
                String textToPrint = linkText.getText();
                System.out.println(textToPrint);
            }
            String title = driver.getTitle();
            if (!title.isEmpty()) {
                System.out.println(title);
            } else {
                System.out.println("Title: EMPTY");
            }
        }
        driver.quit();
    }
}