package com.epam.mentoring.pages;

import com.epam.mentoring.bo.Email;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeMessage extends MainMailPage{

    //локаторы бокового меню gmail
    @FindBy(css = "a[href*='compose']") private WebElement composeEmail;
    @FindBy(name = "to") private WebElement sendTo;
    //мой первый собственный sibling элемент
    @FindBy(xpath = "//div[text()='Тема']/following-sibling::div/input") private WebElement emailSubject;
    @FindBy(xpath = "//div[@role='textbox']") private WebElement emailText;
    @FindBy(css = "div[title*='Закрыть']") private WebElement emailCloseAndSave;
    @FindBy(xpath = "//span[text()='Сохранить и перейти']") private WebElement saveEmail;
    @FindBy(xpath = "//span[text()='Отправить']") private WebElement emailSend;

    public ComposeMessage composeEmail(Email email){
        String recipient = email.getTo();
        String subject = email.getSubject();
        String body = email.getBody();

        //Input recipient data
        System.out.println("Typing recipient address " + recipient);
        waitForElementVisible(sendTo);
        sendTo.sendKeys(recipient);
        sendTo.sendKeys(Keys.RETURN);

        //Input subject and body text
        System.out.println("Typing subject " + subject);
        waitForElementClickable(emailSubject);
        emailSubject.sendKeys(subject);
        System.out.println("Typing body " + body);
        waitForElementVisible(emailText);
        emailText.sendKeys(body);
        return this;
    }

    public ComposeMessage findCompose() {
        waitForElementVisible(composeEmail);
        composeEmail.click();
        return this;
    }

    public ComposeMessage sendEmail(){
        waitForElementVisible(emailSend);
        emailSend.click();
        return this;
    }

    public ComposeMessage emailClose(){
        waitForElementVisible(emailCloseAndSave);
        highlightWebElement(emailCloseAndSave);
        emailCloseAndSave.click();
        waitForElementVisible(saveEmail);
        highlightWebElement(saveEmail);
        saveEmail.click();
        return this;
    }
}
