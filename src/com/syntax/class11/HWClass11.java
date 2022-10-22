package com.syntax.class11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HWClass11 {
    /*  open new browser
        open a new tab
        navigate to a different URL on a new tab / use .switchTo();
     */

    public static String url = "https://www.google.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //ID for the main page
        String mainTab = driver.getWindowHandle();
        //downcast to driver
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //open new tab
        js.executeScript("window.open()");
        //storing all windowHandles in a Set
        Set<String> allTabs= driver.getWindowHandles();
        System.out.println(allTabs);
        System.out.println("Main page is "+driver.getTitle());
        //iterate through the tabs
        Iterator<String> iterator = allTabs.iterator();

        while (iterator.hasNext()){
            //assign the child handle
            String nextTab = iterator.next();
            if (!mainTab.equals(nextTab)){
                driver.switchTo().window(nextTab);
                driver.get("https://www.amazon.com/");
                driver.switchTo().window(mainTab).close();
                driver.switchTo().window(nextTab);
            }
        }
        System.out.println("Child page is "+driver.getTitle());
       driver.quit();

    }
}
