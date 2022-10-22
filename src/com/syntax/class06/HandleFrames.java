package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
    public static String url = "http://www.uitestpractice.com/Students/switchTo";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().frame(0);//switching the focus to the first frame, that is available on the page
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("Batch 12 Forever!!!");

        driver.switchTo().defaultContent(); //switch to the main page

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //handle the alert first
        driver.switchTo().frame("iframe_a");
        //Both texts are concatinated and sent to the text box. In order to avoid this mistake, first clear the textbox
        textbox.clear();
        textbox.sendKeys("We are back to frame");

        driver.switchTo().defaultContent();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
        driver.switchTo().frame(frameElement);
        textbox.clear();
        textbox.sendKeys("Hold your horses");

        driver.quit();

    }
}