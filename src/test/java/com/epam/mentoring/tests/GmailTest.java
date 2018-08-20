package com.epam.mentoring.tests;

import com.epam.mentoring.bo.Email;
import com.epam.mentoring.bo.User;
import com.epam.mentoring.pages.ComposeMessage;
import com.epam.mentoring.pages.DraftPage;
import com.epam.mentoring.pages.LoginPage;
import com.epam.mentoring.pages.MainMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest{

    private static String URL = "https://mail.yandex.ru/";
    private static LoginPage login = new LoginPage();
    private static ComposeMessage compose = new ComposeMessage();
    private static MainMailPage mainPage = new MainMailPage();
    private static DraftPage draftPage = new DraftPage();
    private static String to = "selenium.tester80@gmail.com";
    private static String subject = "Hello brother!";
    private static String body = "I was born later and I'm Russian";

    @Test(description = "Sign in to email")
    public void signIn(){
        // Login via user defined method
        login.openPage(URL).goToLoginPage().signIn(new User());

        // Verify that the login was correct
        Assert.assertEquals(new MainMailPage().checkUser(), "selenium.tester80","It's seems you are NOT logged in correctly");
        System.out.println("Login was completed correctly");
    }

    @Test(description = "Compose Email", dependsOnMethods = {"signIn"})
    public void createAndSendEmail() {
        compose.findCompose().composeEmail(new Email(to,subject,body));
        compose.emailClose();
        mainPage.openDrafts();
        draftPage.emailTextFind(subject);
        mainPage.waitForElementVisible(mainPage.getGmailInbox());
        compose.sendEmail();
        mainPage.openSent();
        draftPage.emailTextFind(subject);
        Assert.assertEquals(draftPage.emailCheck(subject),subject,"No email in Sent folder, please retry");
        System.out.println("Login was completed correctly");
    }

   /* @Test(description = "Sign Out", dependsOnMethods = {"testCheckAndSend"})
    public void signOut() {
        user.signOut();
        Screenshoter.takeScreenshot();
        WebDriverSingleton.kill();
    }
*/

}
