package com.epam.selenium;

import com.epam.add.Email;
import com.epam.add.User;
import com.epam.utils.Screenshoter;
import com.epam.utils.WebDriverSingleton;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseTest {

    private static String login = "selenium.tester80@gmail.com";
    private static String password;
    static {
        try {
            password = new Scanner(new File("/C:/Pwd/pwd.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static User user = new User(login, password);


    @BeforeTest(description = "User sign in")
    public void signIn(){
        user.signIn();
    }

    @AfterTest(description = "User sign out and browser close")
    public void signOut() throws InterruptedException {
        user.signOut();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }

}
