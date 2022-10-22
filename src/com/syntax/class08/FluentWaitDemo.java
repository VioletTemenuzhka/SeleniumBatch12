package com.syntax.class08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();//driver is the object of WebDriver
        //create an object of the fluent wait
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
            //have to mention the dataType you're having in your list or map (in the <>)
            //have to specify the actual object you're running the wait on (in the () )
                .withTimeout(Duration.ofSeconds(5)) //configure the timeout
                .pollingEvery(Duration.ofSeconds(5))//polling means it will be looking for the element for each 5 secs
                    //if for example the implicit wait is 20sec and it is looking every half a sec
                    //when we set the polling method it will look for the element by the given time (in this example 5sec)
                .ignoring(NoSuchFieldException.class);//ignores the exception mentioned in the time of waiting
        //this wait effects the java memory
    }
}
