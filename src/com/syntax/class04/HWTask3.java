package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask3 {
    /* HRMS Application Negative Login:
        Open chrome browser
        Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
        Enter valid username
        Leave password field empty
        Click on login button
        Verify error message with text "Password cannot be empty" is displayed.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        userName.sendKeys("Admin");
        WebElement logInButton = driver.findElement(By.cssSelector("input[id ^= 'btn']"));
        Thread.sleep(2000);
        logInButton.click();
        WebElement errorMsg = driver.findElement(By.id("spanMessage"));
        String errorMessage = errorMsg.getText();
        //System.out.println(errorMessage);
        boolean errorMsgIsDisplayed = errorMsg.isDisplayed();
        System.out.println(errorMsgIsDisplayed);
        if ((errorMsgIsDisplayed) && ("Password cannot be empty".equals(errorMessage))){
            System.out.println("Error message with text "+errorMessage+" is displayed");
        }else{
            System.out.println("No error message is displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}