package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        //1st we have to locate the element we want to interact with. Pay attention if there is ID
        driver.findElement(By.id("email")).sendKeys("syntax@sdrfg.com");//locating over 1element here
        //Line 13 go find element which has an element id with "email" value and
        //after you find it type this specific text in there --> using method .sendKeys()
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.name("login")).click();//method to click on a button
        //when the script executes too fast, we need to add some time to perform slowly
        Thread.sleep(2000);
        //driver.findElement(By.linkText("Forgot password?")).click();//find by linkText - use the whole link text
                //it is in the opening and closing a-tag (<a  >here is the value / the link text<  /a>)
        //if the linkText is short enough, USE .linkText() method to prevent duplicates
        driver.findElement(By.partialLinkText("Forgot")).click();//find the element by partialLinkText - use just a part of the link text
        driver.quit();


    }
}
