package com.epam.pf;

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

/* //Поиск фрейма
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
