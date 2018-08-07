package com.epam.selenium;

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

    String emailTextString = "Some text";
    String emailSubjectString = "Hello world!";
    String sendEmailToString = "newTestAddressee@gmail.com";
    String imageLink = "https://pbs.twimg.com/media/CrwtRNzXEAAzRob.jp";
    String imageLink2 ="g";

    @Test(description = "Login test")
    public void testGmailLogin() throws FileNotFoundException, InterruptedException {
        String password = new Scanner(new File("/C:/Pwd/pwd.txt")).useDelimiter("\\Z").next();
        new LoginPage().openPage().fillLoginInput("selenium.tester80@gmail.com").pressNextButton();
        new PasswordPage().fillPasswordInput(password).pressNextButton();
        MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.waitForElementVisibleBy(By.cssSelector("a[aria-label*='selenium.tester80@gmail.com']"));
        //Assert.assertTrue(driver.findElements(By.cssSelector("a[aria-label*='selenium.tester80@gmail.com']")).size()>0);

    }

    @Test(description = "Compose Email",dependsOnMethods = {"testGmailLogin"})
    public void testGmailSend() throws InterruptedException {
        ComposeMessage composeMessage = new ComposeMessage().findCompose().sendEmailTo(sendEmailToString).emailSubject(emailSubjectString).emailText(emailTextString);
        composeMessage.insertImage();
        Thread.sleep(2000);
        composeMessage.imageSource();
        composeMessage.insertLink(imageLink);
        Thread.sleep(2000);
        composeMessage.insertLink(imageLink2);
        Thread.sleep(2000);
        composeMessage.addImage();
        composeMessage.emailClose();

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
