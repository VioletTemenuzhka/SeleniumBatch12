package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingPaginations {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login actions
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        //navigating to add employee page
        WebElement pimButton = driver.findElement(By.id("menu_pim_view_viewPimModule"));
        pimButton.click();
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();

        //adding employee and saving it
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Diego");
        WebElement lastName  = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Asghar");
        WebElement employeeIdField = driver.findElement(By.id("employeeId"));
        String emplId = employeeIdField.getAttribute("value");
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement employeeListButton = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeListButton.click();


        boolean flag = true;
        while(flag) {
            //locate the element inside the while loop , because the whole page gets refreshed after each next click
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
            for (int i = 0; i < tableRows.size(); i++) {//header is not included in the body--> start from i=0
                String rowText = tableRows.get(i).getText();
                if (rowText.contains(emplId)) {
                    flag = false;
                    WebElement checkbox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" + i + "]/td[1]"));
                    checkbox.click();
                    WebElement deleteButton = driver.findElement(By.id("btnDelete"));
                    deleteButton.click();
                    WebElement confirmDelete = driver.findElement(By.id("DialogDeleteBtn"));
                    confirmDelete.click();
                    break;
                }
            }
            if (flag) {
                //click the next button outside the for loop BUT INSIDE the while loop
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }

        }
    }
}
