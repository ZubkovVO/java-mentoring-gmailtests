package com.epam.pf;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePopup extends AbstractPage{

    //Alert alert;  //обработка модальных окон браузера

    @FindBy(xpath = "//div[text()='selenium.tester80']") private WebElement signOutOptions;
    @FindBy(xpath = "//a[text()='Выйти из сервисов Яндекса']") private WebElement signOut;

    public ProfilePopup signOutOptions() throws InterruptedException {
        waitForElementClickable(signOutOptions);  //ВОПРОС: Почему-то не цеплят клик если не использовать Actions
        highlightWebElement(signOutOptions);
        //clickWebElement(signOutOptions);
        new Actions(driver).click(signOutOptions).build().perform();
        //Thread.sleep(1000);
        //signOut.click();
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
