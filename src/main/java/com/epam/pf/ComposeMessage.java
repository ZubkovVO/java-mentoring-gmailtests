package com.epam.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeMessage extends MainMailPage{

    //локаторы бокового меню gmail
    @FindBy(xpath = "//div[text()='Написать']") private WebElement composeEmail;
    @FindBy(name = "to") private WebElement sendTo;
    @FindBy(name= "subjectbox") private WebElement emailSubject;
    @FindBy(xpath = "//div[@aria-label='Тело письма']") private WebElement emailText;
    @FindBy(xpath = "//img[@aria-label='Сохранить и закрыть']") private WebElement emailCloseAndSave;
    @FindBy(xpath = "//div[contains(@aria-label,'Отправить')]") private WebElement emailSend;
    @FindBy(xpath = "//div[@aria-label='Добавить фото']") private WebElement insertImage;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Загрузка'])[1]/following::div[2]") private WebElement imageSource; //"//div[@aria-label='Закрыть']"
    @FindBy(id = ":p") private WebElement insertLink;
    @FindBy(id = "picker:ap:2") private WebElement addImage;



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

    public ComposeMessage insertImage() {
        waitForElementVisible(insertImage);
        insertImage.click();
        return this;
    }

    public ComposeMessage imageSource() throws InterruptedException {
        Thread.sleep(2000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);

        /*for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total=driver.findElements(By.xpath("//div[@aria-label='Закрыть']")).size();
            System.out.println(total);
            driver.switchTo().defaultContent();}*/

        driver.switchTo().frame(13);
        waitForElementVisible(imageSource);
        imageSource.click();
        return this;
    }

    public ComposeMessage insertLink(String linkText){
        waitForElementVisible(insertLink);
        insertLink.sendKeys(linkText);
        return this;
    }

    public ComposeMessage addImage(){
        waitForElementVisible(addImage);
        addImage.click();
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
        emailCloseAndSave.click();
        return this;
    }
}
