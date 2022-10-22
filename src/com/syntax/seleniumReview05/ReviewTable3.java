package com.syntax.seleniumReview05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewTable3 {
    public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //click on the calendar to open it
        WebElement departCalender = driver.findElement(By.xpath("//button[@class = 'ui-datepicker-trigger'][1]"));
        departCalender.click();

        //check if month is July
        boolean found = false;
        while (!found) {
            //find the month
            WebElement month = driver.findElement(By.xpath("(//span[@class = 'ui-datepicker-month'])[1]"));
            String month_ = month.getText();
            if (month_.equals("July")) {
                List<WebElement> days = driver.findElements(By.xpath("(//table[@class = 'ui-datepicker-calendar'])[1]/tbody/tr/td"));
                for (WebElement day : days) {
                    String dayText = day.getText();
                    if (dayText.equals("25")) {
                        day.click();
                        break;
                    }
                }
                System.out.println(month_);
                found = true;
            } else {
                //a good practice when clicking on a button is to place if condition, beacuse if you run out of options, you'll get an error
                if (!found) {
                    WebElement nextBtn = driver.findElement(By.xpath("//a[@class = 'ui-datepicker-next ui-corner-all']"));
                    nextBtn.click();
                }
            }
        }
        driver.quit();
    }
}