package com.syntax.seleniumReview06.POM.pages;

import com.syntax.seleniumReview06.POM.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonMethods {
    public WebElement username = driver.findElement(By.id("txtUsername"));
    public WebElement password = driver.findElement(By.id("txtPassword"));
    public WebElement loginButton = driver.findElement(By.id("btnLogin"));

    public WebElement invalidCredentialMsg = driver.findElement(By.xpath("//span[text() = 'Invalid credentials']"));

}
