package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HWTask1 {
    /*  Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
        click on leave
        click on leave list
        choose from "From calendar"
        choose from "To calendar"
        click only on cancelled and rejected checkboxes
        uncheck Pending Approval
        select IT support from DD
        click search
        quit the browser
     */

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

        WebElement leaveBtn = driver.findElement(By.linkText("Leave"));
        leaveBtn.click();

        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement fromMonthDD = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));
        Select selectFromMonth = new Select(fromMonthDD);
        selectFromMonth.selectByVisibleText("Jan");

        WebElement fromYearDD = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-year']"));
        Select selectFromYear = new Select(fromYearDD);
        selectFromYear.selectByValue("2021");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement fromDate:fromDates){
            String dateText = fromDate.getText();
            if(dateText.equals("13")){
                fromDate.click();
                break;
            }
        }

        WebElement toCalender = driver.findElement(By.id("calToDate"));
        toCalender.click();

        WebElement toMonthDD = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));
        Select selectToMonth = new Select(toMonthDD);
        selectToMonth.selectByVisibleText("May");

        WebElement toYearDD = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-year']"));
        Select selectToYear = new Select(toYearDD);
        selectToYear.selectByValue("2023");

        List<WebElement> toDates =driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement toDate:toDates){
            String dateText1 = toDate.getText();
            if(dateText1.equals("19")){
                toDate.click();
                break;
            }
        }

        WebElement rejectedCheckBox = driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
        if(!rejectedCheckBox.isSelected()){
            rejectedCheckBox.click();
        }
        WebElement cancelledCheckBox = driver.findElement(By.id("leaveList_chkSearchFilter_0"));
        if(!cancelledCheckBox.isSelected()){
            cancelledCheckBox.click();
        }
        WebElement pendingApprovalCheckBox = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
        if (pendingApprovalCheckBox.isSelected()){
            pendingApprovalCheckBox.click();
        }

        WebElement subUnitDD = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select selectUnit = new Select(subUnitDD);
        selectUnit.selectByVisibleText("IT Support");

        WebElement searchBtn = driver.findElement(By.id("btnSearch"));

        searchBtn.click();

      //  driver.quit();

        //WebElement checkBoxPending = driver.findElement(By.id("//input[@id = 'leaveList_chkSearchFilter_1']"));
        //System.out.println(checkBoxPending.getAttribute("checked"));
        //List<WebElement> allCheckBoxes = driver.findElements(By.id("//div[@class = 'checkbox_group label_first']"));
       // System.out.println(allCheckBoxes.size());

        //Sakir Sahin code
        //List<WebElement> checkboxLabels = driver.findElements(By.xpath("//input[@type='checkbox']/preceding-sibling::label"));
        //System.out.println(checkboxLabels.size());


       /* List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[type = 'checkbox']"));
        System.out.println(allCheckBoxes.size());
        for (WebElement checkBox:allCheckBoxes) {
            String checkBoxText = checkBox.getText();
           if(checkBoxText.equals("Pending Approval")){
               checkBox.click();
           }

        }*/


    }
}
