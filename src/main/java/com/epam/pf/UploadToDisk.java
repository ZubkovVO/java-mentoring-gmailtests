package com.epam.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadToDisk extends AbstractPage {

   // @FindBy(xpath = "//span[@class='button2__text']") private WebElement upload;
    @FindBy(css="input[class='upload-button__attach']") private WebElement upload;
    @FindBy(css="a[data-click-action='dialog.close']") private WebElement close;



     public UploadToDisk uploadFile() throws InterruptedException {
        /*waitForElementVisible(upload);  //ВОПРОС: Почему-то не цеплят клик если не использовать Actions
        highlightWebElement(upload);
        Thread.sleep(2000);
        upload.sendKeys(new File("D:\\1.txt").getAbsolutePath());*/
        driver.findElements(By.cssSelector("input.upload-button__attach")).get(0).
                sendKeys(new File("D:\\1.txt").getAbsolutePath());

        waitForElementVisible(close);
        close.click();

        //new Actions(driver).click(upload).build().perform();
        return this;
    }



}
