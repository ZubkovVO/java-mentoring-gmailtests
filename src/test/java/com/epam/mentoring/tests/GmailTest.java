package com.epam.mentoring.tests;

import com.epam.mentoring.bo.Email;
import com.epam.mentoring.bo.User;
import com.epam.mentoring.pages.*;
import com.epam.mentoring.utils.Browser;
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
    private static ProfilePopup profile = new ProfilePopup();

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
        //Compose new Email with defined params
        compose.findCompose().composeEmail(new Email(to,subject,body));
        compose.emailClose();
        mainPage.openDrafts();
        draftPage.emailTextFind(subject);
        //mainPage.waitForElementVisible(mainPage.getInbox());
        compose.sendEmail();

        //Verify that the email was sent
        Assert.assertEquals(draftPage.emailCheck(),"Письмо отправлено.","No email in Sent folder, please retry");
        System.out.println("Email sent");
    }

    @Test(description = "Sign Out", dependsOnMethods = {"createAndSendEmail"})
    public void signOut() {
        profile.signOutOptions().signOut();
        Browser.kill();
    }

}
