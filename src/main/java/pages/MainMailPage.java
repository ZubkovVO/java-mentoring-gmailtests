package pages;

import org.openqa.selenium.By;

public class MainMailPage extends AbstractPage {

    //поиск ссылок по частичному совпадению, лучше решения не нашел для навигации по элементам на данном этапе
    private static final By INBOX = By.cssSelector("a[href*='#inbox']");
    private static final By DRAFTS = By.cssSelector("a[href*='#draft']");
    private static final By SENT = By.cssSelector("a[href*='#sent']");
    private static final By USER_NAME = By.cssSelector("div[class='mail-User-Name']");
    private static final By USER_NAME_DISK = By.cssSelector("div.user-account>span.user-account__name");


    //getter for Inbox
    public static By getINBOX() {
        return INBOX;
    }
    /*public WebElement getInbox(){
        return this.gmailInbox;
    }*/

    public MainMailPage openInbox(){
        browser.click(INBOX);
        return this;
    }

    public MainMailPage openDrafts(){
        browser.click(DRAFTS);
        return this;
    }

    public MainMailPage openSent(){
        browser.click(SENT);
        return this;
    }

    public String checkUser(){
        return browser.read(USER_NAME);
    }

    public String checkDiskUser(){
        return browser.read(USER_NAME_DISK);
    }

}
