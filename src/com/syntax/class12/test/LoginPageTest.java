package com.syntax.class12.test;

import com.syntax.class12.pages.LoginPage;
import com.syntax.class12.testBase.BaseClass;

public class LoginPageTest {
    //test classes usually don't extend other classes, it is not preferred approach
    public static void main(String[] args) {
        //launch the browser by calling the method from baseClass
        //since it is a
        BaseClass.openWithSpecificUrl("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        //to perform actions we need to have access to the webElements
        //create an obj of it
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.loginButton.click();
        //accessing default variables --> only within the package
    }
}
