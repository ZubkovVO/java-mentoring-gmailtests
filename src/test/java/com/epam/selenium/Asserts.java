package com.epam.selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Asserts {

    public Asserts elementPresent(WebElement element){
        Assert.assertNotNull(element, "Element is present");
        return this;
        //mainMailPage.waitForElementVisibleBy(By.cssSelector("a[aria-label*='selenium.tester80@gmail.com']"));*/
    }
}
