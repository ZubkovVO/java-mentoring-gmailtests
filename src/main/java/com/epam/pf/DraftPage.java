package com.epam.pf;

import com.epam.utils.Screenshoter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends MainMailPage {

    private static final By TRASH_CAN = By.cssSelector("a[href*='inbox']");
    /*Вопрос: почему или как использовать FindBY вместо конструкции с константой
    @FindBy(linkText = "Корзина") private WebElement trash;*/

    //использован параметризированный подход к вычислению ссылки, сам поиск письма так себе
    public DraftPage emailTextFind(String textCheck) {
        By textLocator = By.xpath("//span[text()='" + textCheck + "']");
        waitForElementVisibleBy(textLocator);
        driver.findElement(textLocator).click();
        return this;
    }

    /*public DraftPage emailDoppable(String textCheck) {
        By textLocator = By.xpath("//span[text()='" + textCheck + "']");
        waitForElementVisibleBy(textLocator);
        waitForElementVisibleBy(TRASH_CAN);
        WebElement element = driver.findElement(textLocator);
        WebElement target = driver.findElement(TRASH_CAN);
        highlightElement(textLocator);
        Screenshoter.takeScreenshot();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, target);
        actions.build().perform();
        Screenshoter.takeScreenshot();
        return this;
    }*/
}
