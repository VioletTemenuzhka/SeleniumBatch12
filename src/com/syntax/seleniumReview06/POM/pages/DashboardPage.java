package com.syntax.seleniumReview06.POM.pages;

import com.syntax.seleniumReview06.POM.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends CommonMethods {
    public WebElement dasboardPageMsg = driver.findElement(By.id("welcome"));
}
