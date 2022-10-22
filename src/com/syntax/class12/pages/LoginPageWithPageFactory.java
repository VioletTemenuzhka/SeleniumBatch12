package com.syntax.class12.pages;

import com.syntax.class12.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory extends CommonMethods {

    //@FindBy annotation - locate the element but don't initialize it
    //the most used approach nowadays to store the webElements

    @FindBy(id = "txtUsername")//locator and value
    public WebElement username;

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement password;

    @FindBy(css = "input#btnLogin")
    public WebElement loginButton;

    public LoginPageWithPageFactory(){//public --> to be accessible in the whole project
        PageFactory.initElements(driver, this);//we use this in order to initialize the variables above
    }
}
