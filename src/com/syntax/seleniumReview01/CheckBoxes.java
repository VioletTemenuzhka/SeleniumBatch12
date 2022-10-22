package com.syntax.seleniumReview01;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");

//        check the check box
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#isAgeSelected"));
        System.out.println("the checkbox is selected"+checkbox1.isSelected());
//        select the checkbox
        checkbox1.click();
        Thread.sleep(3000);
        WebElement textelement = driver.findElement(By.xpath("//div[text()=\"Success - Check box is checked\"]"));
        System.out.println(textelement.getText());
        //        deselect the checkbox
        checkbox1.click();

//        get al;l the available options
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement checkbox :checkboxes){
            checkbox.click();
        }
        Thread.sleep(2000);
        for (WebElement checkbox :checkboxes){
            checkbox.click();
        }


    }
}