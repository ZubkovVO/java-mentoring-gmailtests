package com.epam.add;

import com.epam.pf.LoginPage;
import com.epam.pf.MainMailPage;
import com.epam.pf.PasswordPage;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Scanner;

public class Login {

    public Login(String login, String password){

        new LoginPage().openPage().fillLoginInput(login).pressNextButton();
        new PasswordPage().fillPasswordInput(password).pressNextButton();
        /*MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.waitForElementVisibleBy(By.cssSelector("a[aria-label*='selenium.tester80@gmail.com']"));*/

    }
}
