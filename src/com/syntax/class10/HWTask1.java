package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HWTask1 {
    /*  Go to aa.com/homePage.do
        select depart date
        select return date
        select destination
        click on search
        quit the browser
     */
    public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement departCalender = driver.findElement(By.xpath("//button[@class = 'ui-datepicker-trigger'][1]"));
        departCalender.click();


        WebElement departMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month'][1]"));
        String depMonthText = departMonth.getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'ui-datepicker-month'][1]")));

        while (!depMonthText.equals("October")) {
            //next button is refreshing --> find it before click on it
            WebElement nextMonthBtn = driver.findElement(By.xpath("//a[@class = 'ui-datepicker-next ui-corner-all']"));
            nextMonthBtn.click();
            departMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month'][1]"));
            depMonthText = departMonth.getText();
        }

        List<WebElement> depDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement depDate : depDates) {
            if (depDate.getText().equals("10")) {
                depDate.click();
                break;
            }
        }

        // WebElement returnCalendar = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
        //returnCalendar.click();


        WebElement departAirport = driver.findElement(By.xpath("//span[@class = 'icon icon-search'][1]"));
        departAirport.click();

        WebElement depAirportDD = driver.findElement(By.xpath("//select[@id = 'countryCode']"));
        Select select = new Select(depAirportDD);
        select.selectByVisibleText("Switzerland");

        List<WebElement> depCities = driver.findElements(By.xpath("//tbody[@id = 'airportList']/tr/td[@class = 'airport-code']"));
        Actions action = new Actions(driver);
        for (WebElement depCity : depCities) {
            if (depCity.getText().equals("GVA")) {
             depCity.click();
             break;
            }

        }
        }
    }
