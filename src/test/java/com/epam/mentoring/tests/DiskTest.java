package com.epam.mentoring.tests;

import com.epam.mentoring.bo.User;
import com.epam.mentoring.pages.DiskMain;
import com.epam.mentoring.pages.UploadToDisk;
import com.epam.mentoring.utils.Screenshoter;
import com.epam.mentoring.utils.WebDriverSingleton;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiskTest extends BaseTest {
/*
    private static String login = "tests.tester80@yandex.ru";
    private static String password = "Administratum41";

    private static String url = "https://disk.yandex.ru/";

    private static User user = new User(login, password);
    private static DiskMain diskMain = new DiskMain();

    @Test(description = "Sign In")
    public void signIn(){
        user.signInToDisk();
    }

    @Test(description = "Upload", dependsOnMethods = {"signIn"})
    public void uploadCheck() {
        UploadToDisk upload = new UploadToDisk();
        upload.uploadFile();
    }

    @Test(description = "Delete File", dependsOnMethods = {"uploadCheck"})
    public void deleteFiles() {
        diskMain.deleteFile();
    }

    @Test(description = "Selecting Multiple Files", dependsOnMethods = {"deleteFiles"})
    public void selectMultiple() {
        diskMain.selectFiles();
    }


    @Test(description = "Sign Out", dependsOnMethods = {"selectMultiple"})
    public void signOut() throws InterruptedException {
        user.signOutDisk();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }
*/

}
