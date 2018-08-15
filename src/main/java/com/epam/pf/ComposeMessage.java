package com.epam.pf;

import com.epam.utils.Screenshoter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.CONTROL;

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
    /*@FindBy(xpath = "//div[@aria-label='Добавить фото']") private WebElement insertImage;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Загрузка'])[1]/following::div[2]") private WebElement imageSource; //"//div[@aria-label='Закрыть']"
    @FindBy(id = ":p") private WebElement insertLink;
    @FindBy(id = "picker:ap:2") private WebElement addImage;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Вставьте ссылку на изображение:'])[1]/following::li[1]") private WebElement error;
    @FindBy(xpath = "//div[@command='+emoticon']") private WebElement insertSmile;
    //Что это блин вообще за локаторы, почему он на нормальных не работает, ааааа .....
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='😁'])[1]/following::button[1]") private WebElement happySmile;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Возобновить правку'])[1]/following::button[2]") private WebElement emoticons;*/

    public ComposeMessage sendEmailTo(String addressee){
        waitForElementVisible(sendTo);
        sendTo.sendKeys(addressee);
        sendTo.sendKeys(Keys.RETURN);
        return this;
    }

    public ComposeMessage emailSubject(String subjectText){
        waitForElementClickable(emailSubject);
        emailSubject.sendKeys(subjectText);
        return this;
    }

    public ComposeMessage emailText(String bodyText){
        waitForElementVisible(emailText);
        emailText.sendKeys(bodyText);
        return this;
    }

    /*public ComposeMessage insertImage() {
        waitForElementVisible(insertImage);
        insertImage.click();
        return this;
    }

    public ComposeMessage insertSmile() throws InterruptedException {
        waitForElementVisible(insertSmile);
        insertSmile.click();
        waitForElementClickable(emoticons);
        emoticons.click();
        waitForElementClickable(happySmile);
        happySmile.click();
        Thread.sleep(3000);
        return this;
    }*/

/*
    public ComposeMessage imageSource() throws InterruptedException {
        Thread.sleep(2000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);

        //for(int i=0; i<=size; i++){
          //  driver.switchTo().frame(i);
            //int total=driver.findElements(By.xpath("//div[@aria-label='Закрыть']")).size();
            //System.out.println(total);
            //driver.switchTo().defaultContent();}

        driver.switchTo().frame(13);
        waitForElementVisible(imageSource);
        imageSource.click();
        return this;
    }

    public ComposeMessage insertLink(String linkText) throws InterruptedException {
        waitForElementVisible(insertLink);
        insertLink.sendKeys(linkText);
        return this;
    }

    public ComposeMessage addImage(){
        waitForElementVisible(addImage);
        addImage.click();
        return this;
    }*/

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
