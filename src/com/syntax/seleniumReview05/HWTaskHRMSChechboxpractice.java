package com.syntax.seleniumReview05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HWTaskHRMSChechboxpractice {
    /*  goto syntax hrms application
        In the table in PIM/EmployeeList
        just pick one random username and check it,
        no need to delete it , just make sure it is checked.
        share the screenshot  of the webpage in channel
     */

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login actions
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement pimBtn = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimBtn.click();

       // WebElement table = driver.findElement(By.id("resultTable"));
       // List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        WebElement checkboxToBeSelected = driver.findElement(By.id("ohrmList_chkSelectRecord_30281"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.equals(checkboxToBeSelected)) {
                checkbox.click();
            }
        }

        if (checkboxToBeSelected.isSelected()){
            System.out.println("Desired checkbox is selected");
        }else {
            System.out.println("Checkbox is not selected");
        }

        driver.quit();
    }
}