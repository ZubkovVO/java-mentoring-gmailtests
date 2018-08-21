package com.epam.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainMailPage extends AbstractPage {

    //поиск ссылок по частичному совпадению, лучше решения не нашел для навигации по элементам на данном этапе
    @FindBy(css = "a[href*='#inbox']") private WebElement gmailInbox;
    @FindBy(css = "a[href*='#draft']") private WebElement gmailDrafts;
    @FindBy(css = "a[href*='#sent']") private WebElement gmailSent;
    @FindBy(css = "div[class='mail-User-Name']") private WebElement userName;
    @FindBy(css = "span[class='user-account__name']") private WebElement userNameDisk;

    //getter for gmailInbox
    public WebElement getGmailInbox(){
        return this.gmailInbox;
    }

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

    public MainMailPage openSent(){
        waitForElementVisible(gmailSent);
        gmailSent.click();
        return this;
    }

    public String checkUser(){
        waitForElementVisible(userName);
        return userName.getText();
    }

    public String checkDiskUser(){
        waitForElementVisible(userNameDisk);
        return userNameDisk.getText();
    }

}
