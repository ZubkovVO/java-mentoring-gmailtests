package com.epam.pf;

import com.epam.utils.Screenshoter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DiskMain extends AbstractPage{

//div[@class='listing-item__info']/ancestor::
    @FindBy(xpath = "//span[text()='1.txt']/ancestor::div[@class='listing-item__info']/preceding-sibling::div") private WebElement txtFile;
    @FindBy(xpath = "//span[text()='Корзина']") private WebElement trashCan;
    @FindBy(xpath = "//span[text()='Горы.jpg']") private WebElement file1;
    @FindBy(xpath = "//span[text()='Москва.jpg']") private WebElement file2;
    @FindBy(xpath = "//div[@class='resources-action-bar__body']/following-sibling::span") private WebElement closeX;
///sibling::span




    public DiskMain deleteFile() throws InterruptedException {
        waitForElementVisible(txtFile);
        waitForElementVisible(trashCan);
        highlightWebElement(txtFile);
        //new Actions(driver).clickAndHold(deleteFile).moveToElement(trashCan).release().build().perform();
        Screenshoter.takeScreenshot();
        new Actions(driver).dragAndDrop(txtFile, trashCan).build().perform();
        Screenshoter.takeScreenshot();
        return this;
    }

    public DiskMain selectFiles() throws InterruptedException {
        waitForElementVisible(file1);
        waitForElementVisible(file2);
        highlightWebElement(file1);
        Screenshoter.takeScreenshot();
        new Actions(driver).clickAndHold(file1).moveToElement(file2).release().build().perform();
        waitForElementVisible(closeX);
        highlightWebElement(closeX);
        closeX.click();
        Screenshoter.takeScreenshot();
        unHighlightWebElement(file1);
        return this;
    }


}
