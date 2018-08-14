package com.epam.selenium;

import com.epam.add.ComposeEmail;
import com.epam.add.Login;
import com.epam.pf.*;
import com.epam.utils.Screenshoter;
import com.epam.utils.WebDriverSingleton;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GmailTest{

    private static String emailTextString = "Some text";
    private static String emailSubjectString = "Hello world!";
    private static String sendEmailToString = "newTestAddressee@gmail.com";
    private static String login = "selenium.tester80@gmail.com";


    @Test(description = "Login test")
    public void testGmailLogin() throws FileNotFoundException, InterruptedException {
        String password = new Scanner(new File("/C:/Pwd/pwd.txt")).useDelimiter("\\Z").next();
        new Login(login, password);
             //Assert.assertTrue(driver.findElements(By.cssSelector("a[aria-label*='selenium.tester80@gmail.com']")).size()>0);

    }

    @Test(description = "Compose Email",dependsOnMethods = {"testGmailLogin"})
    public void testGmailSend() throws InterruptedException {
        new ComposeEmail(sendEmailToString, emailSubjectString, emailTextString);

        //Assert.assertFalse(driver.findElements(By.xpath("//div[contains(@aria-label,'Отправить')]")).size()>0);
    }

    @Test(description = "Check and Send email", dependsOnMethods = {"testGmailSend"})
    public void testCheckAndSend() throws InterruptedException {
        new MainMailPage().openDrafts();
        new DraftPage().emailTextFind(emailTextString);
        Thread.sleep(3000); //пока не придумал чем заменить
       /* Assert.assertTrue(driver.findElements(By.xpath("//span[@email='"+sendEmailToString+"']")).size()>0);
        Assert.assertTrue(driver.findElements(By.xpath("//div[text()='"+emailSubjectString+"']")).size()>0);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).getText(),emailTextString);*/
        new ComposeMessage().sendEmail();
        MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.openSent();
        new ProfilePopup().signOutOptions().signOut();
        Thread.sleep(2000);
        Screenshoter.takeScreenshot();
    }

    @AfterClass(description = "Close browser")
    public void kill() { WebDriverSingleton.kill(); }
}
