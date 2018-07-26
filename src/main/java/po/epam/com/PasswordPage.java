package po.epam.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PasswordPage extends AbstractPage{

    private static final By PWD_INPUT_LOCATOR = By.cssSelector("input[name='password']");
    private static final By NEXT_BUTTON_LOCATOR = By.name("password");

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public PasswordPage fillPasswordInput(String query){

        waitForElementVisible(PWD_INPUT_LOCATOR);
        driver.findElement(PWD_INPUT_LOCATOR).sendKeys(query);
        return this;

    }

    public  MainMailPage pressNextButton(){
        driver.findElement(NEXT_BUTTON_LOCATOR).sendKeys(Keys.ENTER);
        return new MainMailPage(driver);
    }
}
