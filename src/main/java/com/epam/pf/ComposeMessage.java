package com.epam.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeMessage extends MainMailPage{

    //локаторы бокового меню gmail
    @FindBy(xpath = "//div[text()='Написать']")
    private WebElement composeEmail;

    @FindBy(name = "to")
    private WebElement sendTo;

    @FindBy(name= "subjectbox")
    private WebElement emailSubject;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElement emailText;

    @FindBy(xpath = "//img[@aria-label='Сохранить и закрыть']")
    private WebElement emailCloseAndSave;

    @FindBy(xpath = "//div[contains(@aria-label,'Отправить')]")
    private WebElement emailSend;

    public ComposeMessage(WebDriver driver) {
        super(driver);
    }

    public ComposeMessage sendEmailTo(String addressee){
        waitForElementVisible(sendTo);
        sendTo.sendKeys(addressee);
        return this;
    }

    public ComposeMessage emailSubject(String subjectText){
        waitForElementVisible(emailSubject);
        emailSubject.sendKeys(subjectText);
        return this;
    }

    public ComposeMessage emailText(String bodyText){
        waitForElementVisible(emailText);
        emailText.sendKeys(bodyText);
        return this;
    }


    public ComposeMessage findCompose() {
        waitForElementVisible(composeEmail);
        composeEmail.click();
        return this;
    }

    public ComposeMessage sendEmail(){
        waitForElementClickable(emailSend);
        emailSend.click();
        return this;
    }

    public ComposeMessage emailClose(){
        waitForElementVisible(emailCloseAndSave);
        emailCloseAndSave.click();
        return this;
    }
}
