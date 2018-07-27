package com.epam.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMailPage extends AbstractPage {

    //поиск ссылок по частичному совпадению, лучше решения не нашел для навигации по элементам на данном этапе
    @FindBy(css = "a[href*='inbox']")
    private WebElement gmailInbox;

    @FindBy(css = "a[href*='drafts']")
    private WebElement gmailDrafts;

    @FindBy(css = "a[href*='sent']")
    private WebElement gmailSent;

    public MainMailPage(WebDriver driver) {
        super(driver);
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

}
