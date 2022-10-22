package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AizhanTask2 {
    public static void main(String[] args) throws InterruptedException {


     System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Aizhan");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Kulmagambetova");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email__")).sendKeys("aijeke_91");
        Thread.sleep(2000);
        driver.findElement(By.id("password_step_input")).sendKeys("PIO8989kjl");
        Thread.sleep(2000);
        driver.findElement(By.name("websubmit")).click();


}
}

