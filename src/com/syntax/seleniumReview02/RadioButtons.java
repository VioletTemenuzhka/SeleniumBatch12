package com.syntax.seleniumReview02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();

        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");
        WebElement femaleBtn = driver.findElement(By.xpath("//input[@name='optradio'and@value='Female']"));

        //check if the radiobutton is enabled
        System.out.println("The Female radio button is enabled "+femaleBtn.isEnabled());

        //check if the radiobutton is displayed (is visible on the page)
        System.out.println("The Female radio button is displayed "+femaleBtn.isDisplayed());

        //check if the radiobutton is selected
        System.out.println("The Female radio button is selected "+femaleBtn.isSelected());

        //check if the button is selected and if it is not, select it
        if(!femaleBtn.isSelected()){
            femaleBtn.click();
        }

        //check the status of the button again
        System.out.println("The Female radio button is selected "+femaleBtn.isSelected());

        driver.quit();

    }
}
