package com.syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RightAndDoubleClickActions {
    public static String url = "https://demo.guru99.com/test/simple_context_menu.html";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement rightClickBtn = driver.findElement(By.xpath("//span[text() = 'right click me']"));
        Actions action = new Actions(driver);
        //whenever you need to perform right click on an element, you need to use .contextClick()
        //with right click you can use implicit wait if you want to locate the element
        // or explicit wait if you want to wait for the whole menu to load
        action.contextClick(rightClickBtn).perform();

        //We can use explicit wait with    wait.until(ExpectedConditions.alertIsPresent()) to wait for the alert
        WebElement editOption = driver.findElement(By.xpath("//span[text() = 'Edit']"));
       //editOption.click(); //.click() from the general selenium library
        action.click(editOption).perform(); //click with the Action library
       // Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[contains(text(), 'Double-Click')]"));
        action.doubleClick(doubleClickButton).perform();
        System.out.println(alert.getText());
        alert.accept();

        driver.quit();
    }
}
