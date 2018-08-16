package com.epam.pf;

import org.openqa.selenium.By;

public class DraftPage extends MainMailPage {

    //использован параметризированный подход к вычислению ссылки, сам поиск письма так себе
    public DraftPage emailTextFind(String textCheck) {
        By textLocator = By.xpath("//span[text()='" + textCheck + "']");
        waitForElementVisibleBy(textLocator);
        driver.findElement(textLocator).click();
        return this;
    }
}
