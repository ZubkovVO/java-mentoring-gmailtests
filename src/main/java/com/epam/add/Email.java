package com.epam.add;

import com.epam.pf.ComposeMessage;
import com.epam.pf.DraftPage;
import com.epam.pf.MainMailPage;
import com.epam.pf.ProfilePopup;

public class Email {

    private static String imageLink = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp";
    private static String imageLink2 = ".png";
    private String to;
    private String subject;
    private String body;

    public Email(String to, String subject, String body){

        this.to = to;
        this.subject = subject;
        this.body = body;

    }

    public void compose() throws InterruptedException {
        ComposeMessage composeMessage = new ComposeMessage().findCompose().sendEmailTo(to).emailSubject(subject).emailText(body);
        composeMessage.insertImage();
        composeMessage.imageSource();
        composeMessage.insertLink(imageLink);
        Thread.sleep(2000);
        composeMessage.insertLink(imageLink2);
        composeMessage.addImage();
        composeMessage.emailClose();
    }

    public void send() throws InterruptedException {
        new MainMailPage().openDrafts();
        new DraftPage().emailTextFind(body);
        Thread.sleep(3000); //пока не придумал чем заменить
        new ComposeMessage().sendEmail();
        MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.openSent();
    }
}
