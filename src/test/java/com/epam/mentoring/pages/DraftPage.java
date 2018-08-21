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

    public String emailCheck() {
        By textLocator = By.xpath("//div[text()='Письмо отправлено.']");
        waitForElementVisibleBy(textLocator);
        String text = driver.findElement(textLocator).getText();
        System.out.println("Checking if the specific text is present on the page: " + text);
        return text;
    }



}
