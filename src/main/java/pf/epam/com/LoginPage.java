package pf.epam.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "identifierId")
    private WebElement loginInput;

    @FindBy(xpath = "//div[@id='identifierNext']/content/span")
    private WebElement nextButton;

    private static final String URL = "https:/gmail.com/";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage openPage(){
        driver.get(URL);
        return this;
    }

    public LoginPage fillLoginInput(String query){

        loginInput.sendKeys(query);
        return this;

    }

    public PasswordPage pressNextButton(){
        nextButton.click();
        return new PasswordPage(driver);
    }
}
