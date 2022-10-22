package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HWTask2 {
    /*  navigate to http://www.uitestpractice.com/Students/Contact
        click on the link
        get text
        print out in the console
     */

    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement linkButton = driver.findElement(By.linkText("This is a Ajax link"));
        linkButton.click();
        WebElement textInAjaxLink = driver.findElement(By.xpath("//div[@class = 'ContactUs']"));
        String getTextFromLink = textInAjaxLink.getText();
        System.out.println(getTextFromLink);

        driver.quit();

    }
}