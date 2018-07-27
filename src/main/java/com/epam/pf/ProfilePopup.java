package com.epam.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePopup extends AbstractPage{

    @FindBy(xpath = "//a[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")
    private WebElement signOutOptions;

    @FindBy(xpath = "//a[text()='Выйти']")
    private WebElement signOut;

    public ProfilePopup(WebDriver driver) {
        super(driver);
    }

    public ProfilePopup signOutOptions(){
        waitForElementVisible(signOutOptions);
        signOutOptions.click();
        return this;
    }

    public ProfilePopup signOut(){
        waitForElementVisible(signOut);
        signOut.click();
        return this;
    }


}
