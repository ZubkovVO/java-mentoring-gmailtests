package com.epam.mentoring.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePopup extends AbstractPage{

    //Alert alert;  //обработка модальных окон браузера

    private static final By SIGN_OUT_OPTIONS = By.xpath("//div[text()='selenium.tester80']");
    private static final By SIGN_OUT = By.xpath("//a[text()='Выйти из сервисов Яндекса']");
    private static final By SIGN_OUT_DISK_OPTIONS = By.cssSelector("a.user-account>div.user-pic");
    private static final By SIGN_OUT_DISK = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Управление аккаунтом'])[1]/following::a[1]");
    private static final By ACTION_BAR = By.cssSelector("div[class='resources-action-bar__body']");
    private static final By CHECK_11 = By.cssSelector("a[href='https://mail.yandex.ru'");


    public ProfilePopup signOutOptions() {
        browser.actionClick(SIGN_OUT_OPTIONS);
        /*waitForElementClickable(signOutOptions);
        highlightWebElement(signOutOptions);
        waitForElementVisible(new MainMailPage().getInbox());
        new Actions(driver).click(signOutOptions).build().perform();*/
        return this;
    }

    public ProfilePopup signOutDiskOptions() throws InterruptedException {
        browser.waitForAjaxProcessed();
        browser.actionClick(SIGN_OUT_DISK_OPTIONS);
        /*waitForElementVisible(signOutDiskOptions);
        waitForAjaxProcessed();
        highlightWebElement(signOutDiskOptions);
        new Actions(driver).click(signOutDiskOptions).build().perform();*/
        return this;
    }

    public ProfilePopup signOutDisk(){
        browser.click(SIGN_OUT_DISK);
        return this;
    }

    public ProfilePopup signOut(){
        browser.click(SIGN_OUT);
        //при появлении модального окна, оно закроется
        /*alert = driver.switchTo().alert();
        alert.accept();*/
        return this;
    }
}
