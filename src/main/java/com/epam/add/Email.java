package com.epam.add;

import com.epam.pf.ComposeMessage;
import com.epam.pf.DraftPage;
import com.epam.pf.MainMailPage;

public class Email {

    private String to;
    private String subject;
    private String body;

    public Email(String to, String subject, String body){

        this.to = to;
        this.subject = subject;
        this.body = body;

    }

    public void compose() {
        ComposeMessage composeMessage = new ComposeMessage().findCompose().sendEmailTo(to).emailSubject(subject).emailText(body);
        composeMessage.emailClose();
    }

    public void send() {
        new MainMailPage().openDrafts();
        new DraftPage().emailTextFind(body);
        new MainMailPage().waitForElementVisible(new MainMailPage().getGmailInbox());
        new ComposeMessage().sendEmail();
        MainMailPage mainMailPage = new MainMailPage();
        mainMailPage.openSent();
    }
}
