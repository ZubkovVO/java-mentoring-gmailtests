package com.epam.add;

import com.epam.pf.ComposeMessage;

public class ComposeEmail {

    private static String imageLink = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp";
    private static String imageLink2 = ".png";

    public ComposeEmail(String to, String subject, String body) throws InterruptedException {
        ComposeMessage composeMessage = new ComposeMessage().findCompose().sendEmailTo(to).emailSubject(subject).emailText(body);
        composeMessage.insertImage();
        composeMessage.imageSource();
        composeMessage.insertLink(imageLink);
        Thread.sleep(2000);
        composeMessage.insertLink(imageLink2);
        composeMessage.addImage();
        composeMessage.emailClose();
    }
}
