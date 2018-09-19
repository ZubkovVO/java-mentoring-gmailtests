package pages;

import bo.User;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private static final By GO_TO_LOGIN_PAGE = By.linkText("Войти");
    private static final By GO_TO_LOGIN_DISK = By.xpath("//div[@class='header__row']/div[2]/a");
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PWD_INPUT = By.name("passwd");
    private static final By NEXT_BUTTON = By.xpath("//button[@type='submit']");

    //private static final String URLDISK = "https://disk.yandex.ru/";

    public LoginPage openPage(String URL){
        browser.open(URL);
        return this;
    }

    public LoginPage diskLogin(){
        browser.click(GO_TO_LOGIN_DISK);
        return this;
    }

    public LoginPage goToLoginPage(){
        browser.click(GO_TO_LOGIN_PAGE);
        return this;
    }

    public MainMailPage signIn(User user){
        //defining variables to use inside the method
        String login = user.getLogin();
        String password = user.getPassword();

        //enter username
        System.out.println("Typing user login " + login);
        browser.type(LOGIN_INPUT, login);

        //enter password
        System.out.println("Typing password " + password);
        browser.type(PWD_INPUT, password);

        //press next button and go to the main page
        browser.sendKeys(NEXT_BUTTON);
        return new MainMailPage();
    }
}
