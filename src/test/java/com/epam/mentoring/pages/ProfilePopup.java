package com.epam.mentoring.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePopup extends AbstractPage{

    //Alert alert;  //обработка модальных окон браузера

    @FindBy(xpath = "//div[text()='selenium.tester80']") private WebElement signOutOptions;
    @FindBy(xpath = "//a[text()='Выйти из сервисов Яндекса']") private WebElement signOut;
    @FindBy(css = "a.user-account>div.user-pic") private WebElement signOutDiskOptions;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Управление аккаунтом'])[1]/following::a[1]") private WebElement signOutDisk;
    @FindBy(css = "div[class='resources-action-bar__body']") private WebElement actionBar;
    @FindBy(css = "a[href='https://mail.yandex.ru'") private WebElement check11;

    public ProfilePopup signOutOptions() throws InterruptedException {
        Thread.sleep(2000);
        //waitForAjaxProcessed();
        waitForElementClickable(signOutOptions);
        highlightWebElement(signOutOptions);
        waitForElementVisible(new MainMailPage().getGmailInbox());
        new Actions(driver).click(signOutOptions).build().perform();
        Thread.sleep(2000);
        return this;
    }

    public ProfilePopup signOutDiskOptions() {
        waitForElementVisible(signOutDiskOptions);
        waitForAjaxProcessed();
        highlightWebElement(signOutDiskOptions);
        new Actions(driver).click(signOutDiskOptions).build().perform();
        return this;
    }

    public ProfilePopup signOutDisk(){
        waitForElementClickable(signOutDisk);
        signOutDisk.click();
        return this;
    }

    public ProfilePopup signOut(){
        waitForElementClickable(signOut);
        signOut.click();
        //при появлении модального окна, оно закроется
        /*alert = driver.switchTo().alert();
        alert.accept();*/
        return this;
    }
}
