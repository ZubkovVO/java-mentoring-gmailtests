package pages;

import bo.Email;
import org.openqa.selenium.By;

public class ComposeMessage extends MainMailPage{

    //Yandex side menu locators
    private static final By COMPOSE_EMAIL = By.cssSelector("span.mail-ComposeButton-Text");
    private static final By SEND_TO = By.name("to");
    //sibling element
    private static final By EMAIL_SUBJECT = By.xpath("//div[text()='Тема']/following-sibling::div/input");
    private static final By EMAIL_TEXT = By.xpath("//div[@role='textbox']");
    private static final By EMAIL_CLOSE_AND_SAVE = By.xpath("//div[@title='Закрыть']");
    private static final By SAVE_EMAIL = By.xpath("//span[text()='Сохранить и перейти']");
    private static final By EMAIL_SEND = By.xpath("//span[text()='Отправить']");

    public ComposeMessage composeEmail(Email email){
        String recipient = email.getTo();
        String subject = email.getSubject();
        String body = email.getBody();

        //Input recipient data
        System.out.println("Typing recipient address " + recipient);
        browser.type(SEND_TO, recipient);
        browser.sendKeys(SEND_TO);

        //Input subject and body text
        System.out.println("Typing subject " + subject);
        browser.type(EMAIL_SUBJECT, subject);

        System.out.println("Typing body " + body);
        browser.type(EMAIL_TEXT, body);
        return this;
    }

    public ComposeMessage findCompose() {
        browser.click(COMPOSE_EMAIL);
        return this;
    }

    public ComposeMessage sendEmail(){
        browser.click(EMAIL_SEND);
        return this;
    }

    public ComposeMessage emailClose(){
        browser.click(EMAIL_CLOSE_AND_SAVE);
        browser.click(SAVE_EMAIL);
        return this;
    }
}
