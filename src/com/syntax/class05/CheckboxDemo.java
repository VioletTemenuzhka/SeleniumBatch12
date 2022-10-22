package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxDemo {
   public static String url= "https://syntaxprojects.com/basic-checkbox-demo.php";
   //it is not working without making the url variable static
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        //we cannot have nonstatic variables in a static method!!!!
        List<WebElement> optionCheckboxes = driver.findElements(By.cssSelector("input[class = 'cb1-element']"));
        //line 18 locating checkboxes and storing them in the list
        int size=optionCheckboxes.size();
        System.out.println(size);

        //looping through each element
        for(WebElement option:optionCheckboxes){
            //option.click();
            //in order to click only on opt2, we need to get the attribute and remove line 25
            //because we need to click only opt2, not every checkbox before the desired one
            String checkBoxText = option.getAttribute("value");

            if (checkBoxText.equals("Option-2")){
                option.click();
                break;
            }

            }
        }



    }
