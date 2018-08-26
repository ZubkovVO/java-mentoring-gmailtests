package com.epam.mentoring;

import com.epam.mentoring.pages.MainMailPage;
import org.testng.Assert;

public class Asserts {

    public void successfulLogin(){
        Assert.assertTrue(new MainMailPage().getGmailInbox().isDisplayed(),"login Failed");

    }

}
