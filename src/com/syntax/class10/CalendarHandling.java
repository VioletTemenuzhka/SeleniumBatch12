package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandling {
    public static String url = "https://www.delta.com/";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//span[text() = 'Next']"));
        WebElement departureMonth = driver.findElement(By.className("dl-datepicker-month-0"));
        String depMonthText = departureMonth.getText();

        while(!depMonthText.equals("August")){
            nextButton.click();
            //get the updated text; reassign the value to stop when you need
            depMonthText = departureMonth.getText();
        }

        List<WebElement> depDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
        for(WebElement depDate:depDates){
            if(depDate.getText().equals("13")){
                depDate.click();
                break;
            }
        }

        WebElement returnMonth = driver.findElement(By.className("dl-datepicker-month-1"));
        //get the text
        String returnMonthText = returnMonth.getText();

        while(!returnMonthText.equals("November")){
            nextButton.click();
            //get the updated text
            returnMonthText = returnMonth.getText();
        }

        List<WebElement> returnDates = driver.findElements(By.className("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
        for (WebElement returnDate:returnDates) {
            if(returnDate.getText().equals("30")){
                returnDate.click();
                break;
            }
        }

        WebElement doneButton = driver.findElement(By.className("donebutton"));
        doneButton.click();

        driver.quit();

    }
}
