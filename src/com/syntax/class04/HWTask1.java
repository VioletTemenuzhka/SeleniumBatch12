package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {

        /* Open chrome browser
            Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
            Enter valid username and password (username - Admin, password - Hum@nhrm123)
            Click on login button
            Then verify Syntax Logo is displayed.
         */
        public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement logInButton = driver.findElement(By.cssSelector("input[id ^= 'btn']"));
        Thread.sleep(2000);
        logInButton.click();
        WebElement logo = driver.findElement(By.cssSelector("img[alt *= 'Orange']"));
        boolean logoIsDisplayed = logo.isDisplayed();
        System.out.println(logoIsDisplayed);
        if (logoIsDisplayed){
            System.out.println("Syntax logo is displayed");
        }else{
            System.out.println("Syntax logo is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
