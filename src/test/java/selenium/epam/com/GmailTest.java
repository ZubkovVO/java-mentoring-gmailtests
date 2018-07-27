package selenium.epam.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pf.epam.com.*;

public class GmailTest {
    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    private void initBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions(); //Опции для запуска firefox
        //options.addArguments("disable-infobars");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize(); //во весь экран
    }

    @Test(description = "Login test")
    public void gmailLoginTest() {
        String emailTextString = "Some text";
        String emailSubjectString = "Hello world!";
        String sendEmailToString = "newTestAddressee@gmail.com";

        new LoginPage(driver).openPage().fillLoginInput("selenium.tester80@gmail.com").pressNextButton();
        new PasswordPage(driver).fillPasswordInput("Administratum41").pressNextButton();
        //Assert.assertTrue();

        new ComposeMessage(driver).findCompose().sendEmailTo(sendEmailToString).emailSubject(emailSubjectString).emailText(emailTextString);
        new ComposeMessage(driver).emailClose();
        new MainMailPage(driver).openDrafts();
        new DraftPage(driver).emailTextFind(emailTextString);
        //Assert.assertTrue();
        Assert.assertTrue(driver.findElements(By.xpath("//span[@email='"+sendEmailToString+"']")).size()>0);
        Assert.assertTrue(driver.findElements(By.xpath("//div[text()='"+sendEmailToString+"']")).size()>0);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).getText(),emailTextString);
        new MainMailPage(driver).openSent();
        new ProfilePopup(driver).signOutOptions().signOut();





    }

    /*@Test(description = "Compose draft")
    public void gmailComposeDraft(){

        new MainMailPage(driver).openInbox();
    }*/


    @AfterClass(description = "Close browser")
    public void browserQuit() {
        driver.quit();
    }
}
