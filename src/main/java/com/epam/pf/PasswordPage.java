package com.epam.pf;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {

    @FindBy(css="input[name='password']")
    private WebElement pwdInput;

    @FindBy(name = "password")
    private WebElement nextButton;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public PasswordPage fillPasswordInput(String query){
        waitForElementVisible(pwdInput);
        pwdInput.sendKeys(query);
        return this;

    }

    public MainMailPage pressNextButton(){
        nextButton.sendKeys(Keys.ENTER);
        return new MainMailPage(driver);
    }
}
