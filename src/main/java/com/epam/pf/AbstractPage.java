package com.epam.pf;

import com.epam.utils.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class AbstractPage {
    protected WebDriver driver;
    private static final int WAIT_FOR_ELEMENT_SECONDS = 60;

    public AbstractPage() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElementVisible(WebElement locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOfAllElements(locator));
    }

    public void waitForElementClickable(WebElement locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    //пришлось сделать public для возможности использовать внутри теста GmailTest
    public void waitForElementVisibleBy(By locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    protected void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", element);
    }

    protected void highlightWebElement(WebElement locator){
       ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", locator);

    }

    protected void switchToFrame(int locator){
        driver.switchTo().frame(locator);
    }

    protected void unHighlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }

    //Пока не понял зачем это :)
    private ExpectedCondition<Boolean> isAjaxFinished() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            }
        };
    }

    protected void waitForAjaxProcessed() {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(isAjaxFinished());
    }
}
