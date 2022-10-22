package com.syntax.seleniumReview01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumReviewBasics {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome,driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
        //.get() will wait for the page to fully load
        //driver.navigate("https://mail.google.com/");
        //.navigate() we can refresh, go back and forward, it keeps the history
        driver.quit();


    }
}
