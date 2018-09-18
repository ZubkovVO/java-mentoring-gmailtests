package com.epam.mentoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadToDisk extends AbstractPage {

   // @FindBy(css="input[class='upload-button__attach']") private WebElement upload;
    private static final By UPLOAD= By.cssSelector("input.upload-button__attach");
    private static final By CLOSE = By.cssSelector("a[data-click-action='dialog.close']");
    private static String path = "D:\\1.txt";

//Заняться разбором как будет время

     public UploadToDisk uploadFile() {
        browser.upload(UPLOAD, path);
        /*driver.findElements(By.cssSelector("input.upload-button__attach")).get(0).
                sendKeys(new File("D:\\1.txt").getAbsolutePath());
        waitForElementVisible(close);
        close.click();*/
        browser.click(CLOSE);
        return this;
    }
}
