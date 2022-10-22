package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
    /* Click on the button get new user
     * get the first name text
     * print out in console
     */
    public static String url = "http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //first locate the element
        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();

        //specify explicit wait
        //first you need to create an object of the WebDriver wait
        WebDriverWait wait=new WebDriverWait(driver,20);
                //in the constructor you need to mention 2 things
        //time (seconds) - when do you want the wait to stop waiting and throw an exception. Usual time for any wait is 20 sec
        //what are you using to perform an action; what is the object that you use to perform actions on the web page(driver)

        //specify conditions:
            //use .until() method
            //specify the conditions inside the constructor
        //In this example we're waiting until the element is visible to us on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'First Name')]")));
        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(), 'First Name')]"));
        System.out.println(firstName.getText());

        //driver.quit();

    }
}
