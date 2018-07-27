package com.epam.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{
    /*WebElement loginInput = driver.findElement(By.id("identifierId"));
    WebElement nextButton = driver.findElement(By.xpath("//div[@id='identifierNext']/content/span"));*/

    private static final By LOGIN_INPUT_LOCATOR = By.id("identifierId");
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//div[@id='identifierNext']/content/span");
    private static final String URL = "https:/gmail.com/";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage openPage(){
        driver.get(URL);
        return this;
    }

    public LoginPage fillLoginInput(String query){
        /*WebElement input = driver.findElement(LOGIN_INPUT_LOCATOR);
        input.sendKeys(query);
        Заменяется на нижеследующую конструкцию для лаконичности
         */
        waitForElementVisible(LOGIN_INPUT_LOCATOR);
        driver.findElement(LOGIN_INPUT_LOCATOR).sendKeys(query);
        return this;

    }

    public  PasswordPage pressNextButton(){
        driver.findElement(NEXT_BUTTON_LOCATOR).click();
        return new PasswordPage(driver);
    }
}
