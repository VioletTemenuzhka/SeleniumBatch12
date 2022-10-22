package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HandlingDDWithIterator {
    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement departmentsDD = driver.findElement(By.id("select-demo"));
        Select select = new Select(departmentsDD);
        //isMultiple() gives boolean value and checks if the dropdown can be multiple selected
        boolean isMultiple = select.isMultiple();
        System.out.println(isMultiple);

        if (!isMultiple) {
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> iterator = options.iterator(); //iterating through List of options
            //Iterator is an Interface
            while (iterator.hasNext()) {//checks whenever I am going to the next step if there is something in it
                WebElement ddOption = iterator.next();
                String optionText = ddOption.getText();
                System.out.println(optionText);
            }
        }
    }
}