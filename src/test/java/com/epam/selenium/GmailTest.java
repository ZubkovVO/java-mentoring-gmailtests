package com.epam.selenium;

import com.epam.add.Email;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest{

    private static String emailTextString = "Some text";
    private static String emailSubjectString = "Hello world!";
    private static String sendEmailToString = "newTestAddressee@gmail.com";
    private static Email email = new Email(sendEmailToString, emailSubjectString, emailTextString);

    @Test(description = "Compose Email")
    public void testGmailCompose() throws InterruptedException {
        email.compose();
    }

    @Test(description = "Check and Send email", dependsOnMethods = {"testGmailCompose"})
    public void testCheckAndSend() throws InterruptedException {
        email.send();
    }

}
