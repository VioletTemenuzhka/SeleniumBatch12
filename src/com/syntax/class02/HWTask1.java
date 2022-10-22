package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {
    /*  navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
        fill out the form
        click on register
        close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.name("customer.firstName")).sendKeys("Violet");
        driver.findElement(By.name("customer.lastName")).sendKeys("Testing");
        driver.findElement(By.id("customer.address.street")).sendKeys("asdfg123");
        driver.findElement(By.id("customer.address.city")).sendKeys("City");
        driver.findElement(By.id("customer.address.state")).sendKeys("State");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123-456-7890");
        driver.findElement(By.id("customer.ssn")).sendKeys("987-65-4321");
        driver.findElement(By.id("customer.username")).sendKeys("TestUser");
        driver.findElement(By.id("customer.password")).sendKeys("1234567890");
        driver.findElement(By.id("repeatedPassword")).sendKeys("1234567890");
        Thread.sleep(3000);
        driver.findElement(By.className("button")).click();
        driver.quit();

    }
}





        //driver.findElement(By.name("username")).sendKeys("TestUser");
        //driver.findElement(By.name("password")).sendKeys("1234567890");
        //driver.findElement(By.className("button")).click();