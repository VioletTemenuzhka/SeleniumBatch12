package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HWTask2 {
    /*  Amazon link count:
        Open chrome browser
        Go to "https://www.amazon.com/"
        Get all links
        Get number of links that has text
        Print to console only the links that has text
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int count = allLinks.size();
        int i=0;
        for(WebElement link:allLinks){
            String textLink = link.getText();
            String fullLink = link.getAttribute("href");
            if(!textLink.isEmpty()) {
                System.out.println(textLink + "   " + fullLink);
                i++;
            }
        }
        System.out.println("There are "+i+" links with text in Amazon out of "+count);

        Thread.sleep(5000);
        driver.quit();

    }
}
