package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask2 {
    /* Go to https://syntaxprojects.com/javascript-alert-box-demo.php
        click on each button and handle the alert accordingly
     */

    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement alertBoxBtn = driver.findElement(By.xpath("//button[@onclick = 'myAlertFunction()']"));
        alertBoxBtn.click();
        Alert simpleAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        simpleAlert.accept();

        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[@onclick = 'myConfirmFunction()']"));
        confirmAlertBtn.click();
        Alert confirmAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        //confirmAlert.accept();
        confirmAlert.dismiss();

        WebElement promptAlertBtn = driver.findElement(By.xpath("//button[@onclick = 'myPromptFunction()']"));
        promptAlertBtn.click();
        Alert promptAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        promptAlert.sendKeys("Violet");
        Thread.sleep(2000);
        promptAlert.accept();

        driver.quit();

    }

}
