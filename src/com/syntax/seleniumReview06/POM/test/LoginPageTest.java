package com.syntax.seleniumReview06.POM.test;

import com.syntax.seleniumReview06.POM.pages.DashboardPage;
import com.syntax.seleniumReview06.POM.pages.LoginPage;
import com.syntax.seleniumReview06.POM.testBase.BaseClass;

public class LoginPageTest {
    public static void main(String[] args) {
        //calling the method openWithSpecificUrl from the base class to intitate the driver declaration and open the browser and navigate to sepcific url
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // create an object of the class that has your required Webelements
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("admin");
        loginPage.password.sendKeys("Hum@nhrm123");
        loginPage.loginButton.click();
        //verify that dashboard page is mentioned on the page that opens up
        DashboardPage dash = new DashboardPage();
        dash.dasboardPageMsg.isDisplayed();

        BaseClass.tearDown();
    }
}
