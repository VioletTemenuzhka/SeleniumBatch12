package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask2 {
    /*  navigate to fb.com
        click on create new account
        fill up all the textboxes
        click on sign up button
        close the pop up
        close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Create new")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("TestUser");
        driver.findElement(By.name("lastname")).sendKeys("UserTest");
        driver.findElement(By.name("reg_email__")).sendKeys("testemailfb@test.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testemailfb@test.com");
        driver.findElement(By.id("password_step_input")).sendKeys("123!@#qwe");
        //driver.findElement(By.id("u_2_9_Lj")).click();
        /* since Selenium WebDriver can not test cannot test captchas, images or videos
            clicking on the "X" button is not possible, because this element is an img
            It needs to be done manually.
         */
        driver.quit();


    }
}
