package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.WBufferStrategy;

public class JSExecutorDemo2 {
    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 500)");
        //built-in script --> "window.scrollBy(0, 500)" - in the parenthesis we have to pass the pixels; always starts from 0
       Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -500)");

        WebElement backToTopButton = driver.findElement(By.className("navFooterBackToTopText"));
        js.executeScript("arguments[0].scrollIntoView(true)",backToTopButton);

        driver.quit();

    }
}
