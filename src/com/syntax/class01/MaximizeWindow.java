package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();//maximize the browser (most usable)
        //driver.manage().window().fullscreen();//opens it in full screen
        //the difference between  maximize() and the fullscreen() is that in full screen we cannot see the tabs or the url
    }
}
