package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropDown {
    public static String url = "https://www.amazon.com/";

    //it is not working without making the url variable static
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categoriesDD=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(categoriesDD);
        List<WebElement> options = select.getOptions();
        //use advanced/for each loop
        for (WebElement option :options) {
            String optionText=option.getText();
            System.out.println(optionText);
        }

        select.selectByValue("search-alias=appliances");

    }
}
