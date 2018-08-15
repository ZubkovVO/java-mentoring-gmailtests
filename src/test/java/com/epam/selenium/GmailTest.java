package com.epam.selenium;

import com.epam.add.Email;
import com.epam.add.User;
import com.epam.utils.Asserts;
import com.epam.utils.Screenshoter;
import com.epam.utils.WebDriverSingleton;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GmailTest extends BaseTest{

    private static String login = "selenium.tester80@yandex.ru";
    private static String password;
    static {
        try {
            password = new Scanner(new File("/C:/Pwd/pwd.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static User user = new User(login, password);

    private static String emailTextString = "Some text";
    private static String emailSubjectString = "Hello world!";
    private static String sendEmailToString = "newTestAddressee@gmail.com";
    private static Email email = new Email(sendEmailToString, emailSubjectString, emailTextString);
    private static Asserts check = new Asserts();


    @Test(description = "Sign In")
    public void signIn(){
        user.signIn();
        check.successfulLogin();

        //user.noPhone();
    }

    @Test(description = "Compose Email", dependsOnMethods = {"signIn"})
    public void testGmailCompose() throws InterruptedException {
        email.compose();
    }

    @Test(description = "Check and Send email", dependsOnMethods = {"testGmailCompose"})
    public void testCheckAndSend() throws InterruptedException {
        email.send();
    }

    @Test(description = "Sign Out", dependsOnMethods = {"testCheckAndSend"})
    public void signOut() throws InterruptedException {
        user.signOut();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }


}
