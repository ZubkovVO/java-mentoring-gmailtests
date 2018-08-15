package com.epam.utils;

import com.epam.pf.MainMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Asserts {

    @FindBy(css = "a[href*='#inbox']") private WebElement gmailInbox;

    public void successfulLogin(){
        new MainMailPage().assertT();
        //Boolean isPresent = WebDriver.findElements(gmailInbox).size() > 0;
    }

}
