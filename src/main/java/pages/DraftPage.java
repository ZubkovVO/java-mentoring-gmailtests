package pages;

import org.openqa.selenium.By;

public class DraftPage extends MainMailPage {

    //использован параметризированный подход к вычислению ссылки, сам поиск письма так себе
    public DraftPage emailTextFind(String text) {
        By textLocator = By.xpath("//span[text()='" + text + "']");
        browser.click(textLocator);
        return this;
    }

    public String emailCheck() {
        By textLocator = By.xpath("//div[text()='Письмо отправлено.']");
        browser.waitForElementVisible(textLocator);
        String text = browser.read(textLocator);
        System.out.println("Checking if the specific text is present on the page: " + text);
        return text;
    }



}
