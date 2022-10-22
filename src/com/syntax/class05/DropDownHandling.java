package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {
    public static String url = "https://syntaxprojects.com/basic-select-dropdown-demo.php";

    //it is not working without making the url variable static
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement daysDD = driver.findElement(By.id("select-demo"));//store the found WebElement
        //create a select class object in order to interact with the dropdown where we store the days dropDown - line 21
        Select select=new Select(daysDD);//pass parameter - pass the founded WebElement in the constructor
        //we need to specify which exactly dropdown we're looking for
        select.selectByIndex(3); // indexing starting from zero here
        Thread.sleep(1000);
        select.selectByVisibleText("Thursday");
        Thread.sleep(1000);
        select.selectByValue("Sunday");


        List<WebElement> allOptions = select.getOptions();
        int size= allOptions.size();
        System.out.println(size);

        //retrieve one single value/element from the array list --> by index and using .get(); method
        //only when I get my value, only then I can get the text of it

        for(int i=1; i<=size; i++){
            //i=1 in order to skip the disabled field (Please select)
         //   WebElement option = allOptions.get(i); gets the single webElement
            String option = allOptions.get(i).getText(); //get the text for each element
            System.out.println(option);
            select.selectByIndex(i);
            Thread.sleep(1000);
        }

    }
}
