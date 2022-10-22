package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrders {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        //in order to store a value to a variable you need to define dataType and name it
        //use a variable WebElement without locating it again by creating an instance of it Line 16
        //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        WebElement userName= driver.findElement(By.id("ctl00_MainContent_username"));
        //WebElement is a new data type to store values --> it is for reusibility
        userName.sendKeys("Tester");
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        driver.findElement(By.className("button")).click();
        driver.quit();


    }
}
