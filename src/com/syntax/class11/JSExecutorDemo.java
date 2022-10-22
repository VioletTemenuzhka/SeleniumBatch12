package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //login actions
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        //to create an object of an interface --> we can downcast it or create it indirectly
        JavascriptExecutor js = (JavascriptExecutor)driver; //downcasting to the driver
        js.executeScript("arguments[0].style.backgroundColor='violet'", userName);//pass 2 different arguments
        //built-in script --> arguments[0].style.backgroundColor='red'
        js.executeScript("arguments[0].style.backgroundColor='yellow'",password);
        //loginButton.click();
        js.executeScript("arguments[0].click()",loginButton);

        driver.quit();
    }
}

