package com.epam.mentoring.pages;

import com.epam.mentoring.bo.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.Highlighter;

public class LoginPage extends AbstractPage {

    @FindBy(linkText = "Войти") private WebElement goToLoginPage;
    @FindBy(xpath= "//div[@class='header__row']/div[2]/a") private WebElement goToLoginDisk;
    @FindBy(name = "login") private WebElement loginInput;
    @FindBy(name = "passwd") private WebElement pwdInput;
    @FindBy(xpath = "//button[@type='submit']") private WebElement nextButton;

    private static final String URLDISK = "https://disk.yandex.ru/";

    public LoginPage openPage(String URL){
        driver.get(URL);
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

    public MainMailPage signIn(User user){
        //defining variables to use inside the method
        String login = user.getLogin();
        String password = user.getPassword();

        //enter username
        System.out.println("Typing user login " + login);
        waitForElementVisible(loginInput);
        highlightWebElement(loginInput);
        loginInput.sendKeys(login);

        //enter password
        System.out.println("Typing password " + password);
        waitForElementVisible(pwdInput);
        pwdInput.sendKeys(password);

        //press next button and go to the main page
        waitForElementVisible(nextButton);
        nextButton.sendKeys(Keys.ENTER);
        return new MainMailPage();
    }
}
