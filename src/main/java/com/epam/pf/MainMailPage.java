package com.epam.pf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainMailPage extends AbstractPage {

    //поиск ссылок по частичному совпадению, лучше решения не нашел для навигации по элементам на данном этапе
    @FindBy(css = "a[href*='#inbox']") private WebElement gmailInbox;
    @FindBy(css = "a[href*='#draft']") private WebElement gmailDrafts;
    @FindBy(css = "a[href*='#sent']") private WebElement gmailSent;

    public MainMailPage openInbox(){
        waitForElementVisible(gmailInbox);
        gmailInbox.click();
        return this;
    }

    public MainMailPage openDrafts(){
        waitForElementVisible(gmailDrafts);
        gmailDrafts.click();
        return this;
    }

    public void assertT(){
        Assert.assertTrue(gmailInbox.isDisplayed(),"Login Failed");
    }

    public MainMailPage openSent(){
        waitForElementVisible(gmailSent);
        gmailSent.click();
        return this;
    }

}
