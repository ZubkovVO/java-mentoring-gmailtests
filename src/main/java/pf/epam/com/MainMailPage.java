package pf.epam.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMailPage extends AbstractPage {

    @FindBy(css = "a[href*='inbox']")
    private WebElement gmailInbox;

    @FindBy(css = "a[href*='drafts']")
    private WebElement gmailDrafts;

    /*@FindBy(xpath = "//a[contains(@href,'/#drafts')]")
    private WebElement gmailDrafts;
*/
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
