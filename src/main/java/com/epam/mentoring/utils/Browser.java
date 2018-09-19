package com.epam.mentoring.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.MyLogger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static final int WAIT_ELEMENT_TIMEOUT = 20;
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";
    private WebDriver driver;
    private static Browser instance = null;

    private Browser(WebDriver driver) { this.driver = driver;
    }

    public static Browser getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }


    //driver = new RemoteWebDriver(new URL("http://127.0.0.1:5559/wd/hub"), DesiredCapabilities.chrome());
    private static Browser init() {
        WebDriver driver = null;
        try {
            driver = WebDriverFactory.createWebDriver("Chrome");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new Browser(driver);
    }

    public void open(String url){
        MyLogger.info("Going to URL: " + url);
        driver.get(url);
    }

    public void waitForElementVisible(By locator){
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void highlightElement(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", driver.findElement(locator));
    }

    protected void unHighlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }

    private ExpectedCondition<Boolean> isAjaxFinished() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            }
        };
    }

    public void waitForAjaxProcessed() {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(isAjaxFinished());
    }

    public void click(final By locator) {
        waitForElementVisible(locator);
        MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
        highlightElement(locator);
        takeScreenshot();
        unHighlightElement(locator);
        driver.findElement(locator).click();
    }

    public void upload(final By locator, String path){
       // waitForElementVisible(locator);
        driver.findElements(locator).get(0).
                sendKeys(new File(path).getAbsolutePath());
    }

    public void actionClick(final By locator){
        waitForElementVisible(locator);
        WebElement element = driver.findElement(locator);
        new Actions(driver).click(element).build().perform();
    }

    public void sendKeys(final By locator){
        waitForElementVisible(locator);
        WebDriver decoratedDriver = new WebDriverDecorator(driver);
        decoratedDriver.findElement(locator).sendKeys(Keys.RETURN);
    }

    public void type(final By locator, String text) {
        waitForElementVisible(locator);
        highlightElement(locator);
        MyLogger.info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name") + "' (Located: " + locator + ")");
        driver.findElement(locator).sendKeys(text);
        takeScreenshot();
        unHighlightElement(locator);
    }

    public void typeInUploadInput(final By locator, String text) {
        highlightElement(locator);
        MyLogger.info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name") + "' (Located: " + locator + ")");
        driver.findElement(locator).sendKeys(text);
        takeScreenshot();
        driver.findElement(locator).sendKeys(text);
    }

    public String read(final By locator) {
        waitForElementVisible(locator);
        highlightElement(locator);
        MyLogger.info("Reading text: " + driver.findElement(locator).getText());
        takeScreenshot();
        unHighlightElement(locator);
        return driver.findElement(locator).getText();
    }

    public void dragAndDrop(final By locator, final By targetLocator) {
        waitForElementVisible(locator);
        waitForElementVisible(targetLocator);
        WebElement element = driver.findElement(locator);
        WebElement target = driver.findElement(targetLocator);
        takeScreenshot();
        MyLogger.info("Dragging element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")" +
                "to '" + driver.findElement(targetLocator).getText() + "' (Located: " + targetLocator + ")");
        (new Actions(driver)).dragAndDrop(element, target).perform(); //maybe needed build.
    }

    public void selectSeveralElements(List<By> locators) {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL);
        WebElement element;
        for (By locator : locators) {
            waitForElementVisible(locator);
            highlightElement(locator);
            MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
            element = driver.findElement(locator);
            action.moveToElement(element).click();
        }
        takeScreenshot();
        action.keyUp(Keys.CONTROL).perform();
    }

    public void selectItems(By firstLocator, By lastLocator) {
        new Actions(driver).clickAndHold(driver.findElement(firstLocator)).moveToElement(driver.findElement(lastLocator)).release().build().perform();
        takeScreenshot();
    }

    public boolean isDisplayed(By locator) {
        boolean succeed = driver.findElements(locator).size() > 0;
        if (succeed) {
            MyLogger.info("Element " + driver.findElement(locator).getText() + " is present.");
            highlightElement(locator);
            takeScreenshot();
            unHighlightElement(locator);
        } else MyLogger.error("Element " + driver.findElement(locator).getText() + " is not present.");
        return succeed;
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    private void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            String scrPath = screenshotName + ".jpg";
            File copy = new File(scrPath);
            FileUtils.copyFile(screenshot, copy);
            //MyLogger.info("Saved screenshot: " + screenshotName);
            MyLogger.attach(scrPath, "Screenshot");
        } catch (IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }

    public static void kill() {
        if (instance != null) {
            try {
                instance.driver.quit();
            } catch (Exception e) {
                System.out.println("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }
}
