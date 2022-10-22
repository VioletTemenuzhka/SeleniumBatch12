package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetAllLinksFromEbay {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ebay.com/");
        //find all the ElementS
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        //in order to interact with the elements, we need to store the inside a container, which is called List
        System.out.println("Number of links "+allLinks.size());
        //looping through each and every element inside the container and then start performing actions
        for(WebElement link:allLinks) {
            //get the text, which will return String value
            String linkText = link.getText();
            //to get the link itself/its value, not the text, use attribute href
            String fullLink = link.getAttribute("href");
            if (!linkText.isEmpty()) {
                System.out.println(linkText+"   "+fullLink);
            }
            //code above represents: every time when we loop through the elements
            //it will get us the text of each particular element
            //The empty space, printed in the console are the links without any text
            //in order to get the links only with text in it, use if condition and method isEmpty();
        }
    }
}
