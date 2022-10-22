package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        //1st argument ("webdriver.chrome.driver") - build-in value
        //2nd argument ("Drivers/chromedriver.exe") - the path to the location where the driver is
        //setting property --> mention the location of the browser we'll work with
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");//for windows --> .exe or \\
                                                                                    //for mac --> no extension

        //create an object of an interface(WebDriver) indirectly so we can implement all the methods
        WebDriver driver = new ChromeDriver(); //ChromeDriver class extends the remote WebDriver
        //line 15 launches the browser (only opened it but it doesn;t navigate anywhere
        driver.get("https://www.google.com/");
        //line 17 navigate to the actual website by copying the url
        String url=driver.getCurrentUrl();//getting the url
        System.out.println(url);

        //the title of the Google page is on the tab
        String title=driver.getTitle();//getting the title
        System.out.println(title);
        driver.quit();//closing the browser
    }
}
