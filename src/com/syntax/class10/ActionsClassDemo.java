package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {
    /* navigate to amazon.com
    hover over the cursor onto accounts and lists element

     */
    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));

        //create an object of class Actions
        Actions action = new Actions(driver);//input something that will perform actions on the webpage (driver object in here)
        action.moveToElement(accountsAndLists).perform();


    }
}