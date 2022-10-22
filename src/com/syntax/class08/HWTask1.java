package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HWTask1 {
    /*  go to https://the-internet.herokuapp.com/dynamic_controls
        click on checkbox and click on remove
        verify the text
        click on enable verify the textbox is enabled
        enter text and click disable
        verify the textbox is disabled
     */
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        checkBox.click();

        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement textIsGone = driver.findElement(By.id("message"));
        System.out.println(textIsGone.isDisplayed());
        if(textIsGone.isDisplayed()){
            System.out.println(textIsGone.getText() + " is displayed");
        }

        WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id = 'message']")));
        WebElement displayedText = driver.findElement(By.xpath("//p[@id = 'message']"));
        System.out.println(displayedText.getText() + " is displayed");

        WebElement textBox = driver.findElement(By.tagName("input"));
        System.out.println(textBox.isEnabled());
        if(textBox.isEnabled()){
            textBox.sendKeys("Violet");
            System.out.println("TextBox is enabled");
        }

        WebElement disableButton = driver.findElement(By.xpath("//button[text() ='Disable']"));
        disableButton.click();

        WebElement displayedDisableText = driver.findElement(By.xpath("//p[@id = 'message']"));
        System.out.println(textBox.isEnabled());
        if(!textBox.isEnabled()){
            System.out.println(displayedDisableText.getText() + " is displayed");
            System.out.println("TextBox is disabled");
        }
        driver.quit();
    }
}
