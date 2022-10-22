package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
    /* navigate to https://syntaxprojects.com/window-popup-modal-demo.php
     * click on buttons and open new windows(tabs)
     * switch to windows and perform different actions
     */
    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        String mainPageHandle = driver.getWindowHandle();
        //xpath --> caseSensitive, spaceSensitive
        //linkText --> only the text in "", no spaces before or after the text
        WebElement igButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));

        igButton.click();
        fbButton.click();
        igAndFbButton.click();

        //store all windowHandles in a Set
        Set<String> allWindowHandles = driver.getWindowHandles();//returns linkHashSet, which maintain the order
        System.out.println(allWindowHandles.size());

        //iterate through every element in the set; create iterator
        Iterator<String> it=allWindowHandles.iterator();
        //use while loop to iterate through each element
        while(it.hasNext()){//start iterating through the handles/checks if there is another step(tab/window)
            String handle = it.next(); //get the next handle/moves to the next step
             /*  print out the titles only of the child handles
                 close all child windows
                 keep main page open!!! (you need the if condition)*/
            if(!mainPageHandle.equals(handle)) {//set a condition
                //switch the focus to interact with the tab
                driver.switchTo().window(handle);//switch to a window which is nt equal to main page handle
                //maximize all windows
                driver.manage().window().maximize();
                //get the text/title of each an every link
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }
        //in order to interact with the main page, you need to switch back to it
        driver.switchTo().window(mainPageHandle);//switching back to parent handle
        igButton.click();

    }
}
