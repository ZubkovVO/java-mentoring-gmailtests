package com.epam.pf;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.applet.Main;

public class ProfilePopup extends AbstractPage{

    //Alert alert;  //обработка модальных окон браузера

    @FindBy(xpath = "//div[text()='selenium.tester80']") private WebElement signOutOptions;
    @FindBy(xpath = "//a[text()='Выйти из сервисов Яндекса']") private WebElement signOut;
    @FindBy(css = "a[href*='https://passport.yandex.ru']") private WebElement signOutDiskOptions;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Управление аккаунтом'])[1]/following::a[1]") private WebElement signOutDisk;

    public ProfilePopup signOutOptions() {
        waitForElementClickable(signOutOptions);  //ВОПРОС: Почему-то не цеплят клик если не использовать Actions
        highlightWebElement(signOutOptions);
        waitForElementVisible(new MainMailPage().getGmailInbox());//прогрузка элементов, для обеспечения корректного выхода
        new Actions(driver).click(signOutOptions).build().perform();
        return this;
    }

    public ProfilePopup signOutDiskOptions() throws InterruptedException {
        Thread.sleep(1000); //Опять та же фигня, что с signOutOptions, только тут Actions не спасает
        waitForElementVisible(signOutDiskOptions);  //ВОПРОС: Почему-то не цеплят клик если не использовать Actions
        highlightWebElement(signOutDiskOptions);
        new Actions(driver).click(signOutDiskOptions).build().perform();
        return this;
    }

    public ProfilePopup signOutDisk(){
        waitForElementClickable(signOutDisk);
        signOutDisk.click();
        //при появлении модального окна, оно закроется
        /*alert = driver.switchTo().alert();
        alert.accept();*/
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
