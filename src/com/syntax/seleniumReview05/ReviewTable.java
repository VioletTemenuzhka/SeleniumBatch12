package com.syntax.seleniumReview05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewTable {
    public static String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //accessing the whole table
        WebElement whole_table = driver.findElement(By.xpath("//table[@id='customers']"));
        //print the table
        System.out.println(whole_table);
        //accessing the rows of the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
        for (WebElement row : rows) {
            String text = row.getText();
            if (text.contains("Germany")) {
                System.out.println(text);
            }
        }
        //print only the rows which have the company name as microsoft
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
        System.out.println(columns);
        for (WebElement col:columns){
            String textColumns = col.getText();
            if (textColumns.contains("Microsoft")){
                System.out.println(textColumns);
            }
        }

        // Print all the company names that are located in UK
        // get all the entery in column 3 i.e COUNTRY
        List<WebElement> countries= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));

        int i=1;
        for(WebElement country:countries){

            String nameOfCountry = country.getText();
            if(nameOfCountry.equals("UK")){
                System.out.println(i);
                WebElement company = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (i+1) + "]/td[1]"));
                System.out.println("the company name in UK is "+company.getText());
            }
            i=i+1;
        }

    }
}


        // if column location may change
        //get the headers ---> then find the location of column that has country---> from there he will get the index
        //that should be place in front of td