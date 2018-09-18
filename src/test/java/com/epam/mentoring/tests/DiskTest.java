package com.epam.mentoring.tests;

import com.epam.mentoring.bo.User;
import com.epam.mentoring.pages.*;
import com.epam.mentoring.utils.Screenshoter;
import com.epam.mentoring.utils.WebDriverSingleton;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiskTest {



    private static LoginPage login = new LoginPage();
    private static MainMailPage mainPage = new MainMailPage();
    private static ProfilePopup profile = new ProfilePopup();
    private static String URL = "https://disk.yandex.ru/";
    private static DiskMain diskMain = new DiskMain();

    @Test(description = "Sign In")
    public void signIn() throws InterruptedException {
             // Login via user defined method
            login.openPage(URL).diskLogin().signIn(new User());
            profile.signOutDiskOptions();

            // Verify that the login was correct
            Assert.assertEquals(new MainMailPage().checkDiskUser(), "selenium.tester80","It's seems you are NOT logged in correctly");
            System.out.println("Login was completed correctly");

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
        profile.signOutDiskOptions().signOutDisk();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }


}
