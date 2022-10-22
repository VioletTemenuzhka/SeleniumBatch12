package com.syntax.class12.pages;

import com.syntax.class12.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonMethods {

   public WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));//locate and initialize the variable
   public WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
   public WebElement loginButton = driver.findElement(By.className("button"));


}
