package com.epam.pf;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(linkText = "Войти") private WebElement goToLoginPage;
    @FindBy(name = "login") private WebElement loginInput;
    @FindBy(name = "passwd") private WebElement pwdInput;
    @FindBy(xpath = "//button[@type='submit']") private WebElement nextButton;
    @FindBy(xpath= "//div[@class='header__row']/div[2]/a") private WebElement goToLoginDisk;

    private static final String URL = "https://mail.yandex.ru/";
    private static final String URLDISK = "https://disk.yandex.ru/";

    public LoginPage openMailPage(){
        driver.get(URL);
        return this;
    }

    public LoginPage openDiskPage(){
        driver.get(URLDISK);
        return this;
    }

    public LoginPage diskLogin(){
        waitForElementVisible(goToLoginDisk);
        goToLoginDisk.click();
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
