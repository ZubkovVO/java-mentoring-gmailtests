package com.epam.mentoring.pages;

import org.openqa.selenium.By;

public class DraftPage extends MainMailPage {

    //использован параметризированный подход к вычислению ссылки, сам поиск письма так себе
    public DraftPage emailTextFind(String text) {
        By textLocator = By.xpath("//span[text()='" + text + "']");
        waitForElementVisibleBy(textLocator);
        driver.findElement(textLocator).click();
        return this;
    }

    public String emailCheck(String textCheck) {
        By textLocator = By.xpath("//span[text()='" + textCheck + "']");
        waitForElementVisibleBy(textLocator);
        return driver.findElement(textLocator).getText();
    }



}
