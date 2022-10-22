package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    //Handle each and every alert on the page
    public static String url = "http://www.uitestpractice.com/Students/switchTo";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //to be able to handle the alerts, maximize the browser like so (line 18)
        driver.manage().window().maximize();

        WebElement simpleAlertButton = driver.findElement(By.id("alert")); //identify the alert button
        Thread.sleep(1000);
        simpleAlertButton.click();//click on the alert button
        Alert simpleAlert = driver.switchTo().alert(); //returns alert object; this is from alert interface
        //line 19 switch the focus to the alert in order to handle it
        Thread.sleep(2000);
        simpleAlert.accept();

        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
        Alert confirmAlert = driver.switchTo().alert(); //the object is created to be more understandable
        String alertText = confirmAlert.getText();
        System.out.println(alertText);
        Thread.sleep(1000);
        confirmAlert.dismiss();

        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Batch 12 is the Best");
        Thread.sleep(1000);
        promptAlert.accept();

        driver.quit();
    }
}
