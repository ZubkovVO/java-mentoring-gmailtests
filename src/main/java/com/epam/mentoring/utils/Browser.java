package com.epam.mentoring.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.MyLogger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {


    private static final int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
    private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 10;
    private static final int WAIT_ELEMENT_TIMEOUT = 10;
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

    private static Browser init() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:5557/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new Browser(driver);
    }

    /*private static DesiredCapabilities getChromeDriverProfile(){
        HashMap<String, Object> chromePrefs= new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return capabilities;
    }*/

    public void open(String url){
        MyLogger.info("Going to URL: " + url);
        driver.get(url);
    }

    public void waitForElementVisible(By locator){
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementClickable(WebElement locator){
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
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
        waitForElementVisible(locator);
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
        driver.findElement(locator).sendKeys(Keys.RETURN);
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

    public void resize(By sizeHandleLocator, int xOffset, int yOffset) {
        WebElement handle = driver.findElement(sizeHandleLocator);
        new Actions(driver).clickAndHold(handle).moveByOffset(xOffset, yOffset).release(handle).build().perform();
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
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.info("Saved screenshot: " + screenshotName);
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
