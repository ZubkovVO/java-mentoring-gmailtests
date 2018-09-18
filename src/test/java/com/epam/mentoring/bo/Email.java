package com.epam.mentoring.bo;

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
}
