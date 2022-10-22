package com.syntax.class12.utils;

import com.syntax.class12.testBase.BaseClass;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass {

    /**
     * this method will send text to a given element
     * @param element
     * @param text
     */

    public void sendText (WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }


    public void switchToFrame (int index){
        driver.switchTo().frame(index);
    }

}
