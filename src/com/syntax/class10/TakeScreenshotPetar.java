package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotPetar {
    public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement logInButton = driver.findElement(By.className("button"));
        logInButton.click();

        TakesScreenshot ts = (TakesScreenshot) driver; //downcasted to the driver, because driver is the complete focus of the browser
        File srcFile = ts.getScreenshotAs(OutputType.FILE);//mention output type; getting a file in return
        //line 23 assign the getScreenshotAs() method to an object of the File class --> the screenshot is taken

        // whenever copyFile() gets executed it may throw an exception --> more actions and surrounded with try/catch
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/SmartBear/adminLogin111.png"));
        } catch (IOException e) { //IOException
            e.printStackTrace();
        }
        // screenshots/SmartBear/ --> these 2 folders will be created automatically and it will store it inside our project
        // adminLogin.png --> name of the file can be anything, extension have to be .png or .jpg
        // if we use the same name over and over, it's going to overwrite every time on the previous one
        System.out.println();
    }
}

