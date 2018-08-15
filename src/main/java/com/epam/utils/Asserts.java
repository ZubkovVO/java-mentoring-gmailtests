package com.epam.utils;

import com.epam.pf.MainMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Asserts {

    public void successfulLogin(){
        Assert.assertTrue(new MainMailPage().getGmailInbox().isDisplayed(),"Login Failed");

    }

}
