package com.epam.selenium;

import com.epam.add.Email;
import com.epam.add.User;
import com.epam.pf.UploadToDisk;
import com.epam.utils.Screenshoter;
import com.epam.utils.WebDriverSingleton;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiskTest extends BaseTest {

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

    @Test(description = "Sign In")
    public void signIn(){
        user.signInToDisk();
    }

    @Test(description = "Sign In", dependsOnMethods = {"signIn"})
    public void uploadCheck() throws InterruptedException {
        UploadToDisk upload = new UploadToDisk();
        upload.uploadFile();

    }



    @Test(description = "Sign Out", dependsOnMethods = {"uploadCheck"})
    public void signOut() throws InterruptedException {
        user.signOutDisk();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }


}
