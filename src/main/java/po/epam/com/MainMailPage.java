package po.epam.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMailPage extends AbstractPage{

    private static final By COMPOSE_EMAIL = By.xpath("//div[text()='Написать']");


    public MainMailPage(WebDriver driver) {
        super(driver);
    }


    public MainMailPage findCompose() {
        waitForElementVisible(COMPOSE_EMAIL);
        driver.findElement(COMPOSE_EMAIL).click();
        return this;
    }
}
