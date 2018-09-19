package pages;

import org.openqa.selenium.By;

public class DiskMain extends AbstractPage {

    private static final By TXT_FILE = By.xpath("//span[text()='1.txt']/ancestor::div[@class='listing-item__info']/preceding-sibling::div");
    private static final By TRASH_CAN = By.xpath("//span[text()='Корзина']");
    private static final By FILE_1 = By.xpath("//span[text()='Горы.jpg']");
    private static final By FILE_2 = By.xpath("//span[text()='Москва.jpg']");
    private static final By CLOSE_X = By.xpath("//div[@class='resources-action-bar__body']/following-sibling::span");


    public DiskMain deleteFile() {
        browser.dragAndDrop(TXT_FILE, TRASH_CAN);
        return this;
    }

    public DiskMain selectFiles() {
        browser.selectItems(FILE_1, FILE_2);
        browser.click(CLOSE_X);
        return this;
    }
}
