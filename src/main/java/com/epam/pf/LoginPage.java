package com.epam.pf;

import com.epam.utils.Screenshoter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(linkText = "Войти") private WebElement goToLoginPage;
    @FindBy(name = "login") private WebElement loginInput;
    @FindBy(name = "passwd") private WebElement pwdInput;
    @FindBy(xpath = "//button[@type='submit']") private WebElement nextButton;

    private static final String URL = "https://mail.yandex.ru/";

    public LoginPage openPage(){
        driver.get(URL);
        return this;
    }

    public LoginPage goToLoginPage(){
        waitForElementVisible(goToLoginPage);
        goToLoginPage.click();
        return this;
    }

    public LoginPage enterLogin(String query){
        waitForElementVisible(loginInput);
        loginInput.sendKeys(query);
        return this;
    }

    public LoginPage enterPassword(String query){
        waitForElementVisible(pwdInput);
        pwdInput.sendKeys(query);
        return this;
    }

    public MainMailPage pressNextButton(){
        waitForElementVisible(nextButton);
        nextButton.sendKeys(Keys.ENTER);
        return new MainMailPage();
    }

}
