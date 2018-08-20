package com.epam.mentoring.bo;

import com.epam.mentoring.pages.ComposeMessage;
import com.epam.mentoring.pages.DraftPage;
import com.epam.mentoring.pages.MainMailPage;

public class Email {

    private String to;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Email(String sendTo, String subject, String body){
        this.to = sendTo;
        this.subject = subject;
        this.body = body;
    }



    /*

    public void compose() {
        ComposeMessage composeMessage = new ComposeMessage().findCompose().composeEmail(to).emailSubject(subject).emailText(body);
        composeMessage.emailClose();
    }

    public void send() {
        new MainMailPage().openDrafts();
        new DraftPage().emailTextFind(body);
        new MainMailPage().waitForElementVisible(new MainMailPage().getGmailInbox());
        new ComposeMessage().sendEmail();
        MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.openSent();
    }*/
}
