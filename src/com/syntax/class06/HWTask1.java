package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {
    /* Navigate to https://syntaxprojects.com/bootstrap-iframe.php
       verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
       verify the header text Sorry, We Couldn't Find Anything For "Asksn" is displayed
       verify enroll today button is enabled
     */
    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.xpath("//span[@class = 'gum']"));
        boolean headerIsDisplayed = header.isDisplayed();
        if(headerIsDisplayed) {
            String headerText = header.getText();
            if (headerText.equals("AUTOMATION TESTING PLATFORM BY SYNTAX")) {
                System.out.println("Header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed");
            } else {
                System.out.println("Header is not displayed");
            }
        }
        Thread.sleep(1000);

        driver.switchTo().frame("FrameOne");
        WebElement header1 = driver.findElement(By.xpath("//h1[@class = 'heading-13']"));
        boolean header1IsDisplayed = header1.isDisplayed();
        if(header1IsDisplayed) {
            String header1Text = header1.getText();
            if (header1Text.equals("Sorry, We Couldn't Find Anything For “Asksn”")) {
                System.out.println("Header text Sorry, We Couldn't Find Anything For “Asksn” is displayed");
            }
        }else{
            System.out.println("Header is not displayed");
        }

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        driver.switchTo().frame("FrameTwo");
        WebElement enrollButton = driver.findElement(By.className("text-block-2"));
        //WebElement enrollButton = driver.findElement(By.xpath("//div[@class = 'text-block-2' and text() = 'Enroll today']"));
        //WebElement enrollButton=driver.findElement(By.xpath("//div[text()='Enroll today']"));
        // System.out.println(enrollButton.isEnabled());
        boolean enrollBtnIsEnabled = enrollButton.isEnabled();
        if (enrollBtnIsEnabled){
            System.out.println("Enroll Today button is enabled");
        }else{
            System.out.println("Enroll Today button is NOT enabled");
        }

        driver.quit();

    }
}
