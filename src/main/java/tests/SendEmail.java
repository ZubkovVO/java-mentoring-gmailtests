package tests;

import bo.Email;
import bo.User;
import com.epam.mentoring.utils.Browser;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;

public class SendEmail {

    private static String URL = "https://mail.yandex.ru/";
    private static LoginPage login = new LoginPage();
    private static ComposeMessage compose = new ComposeMessage();
    private static MainMailPage mainPage = new MainMailPage();
    private static DraftPage draftPage = new DraftPage();
    private static ProfilePopup profile = new ProfilePopup();

    @Given("^I Sign in to Yandex mail$")
    public void iSignInToYandexMail() throws Throwable {
        login.openPage(URL).goToLoginPage().signIn(new User());
    }

    @When("^I Open new email$")
    public void iOpenNewEmail() throws Throwable {
        compose.findCompose();
    }

    @And("^I Write \"([^\"]*)\", with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iWriteWithAnd(String to, String subject, String body) throws Throwable {
        compose.composeEmail(new Email(to,subject,body));
    }

    @And("^Close email choosing to save as draft$")
    public void closeEmailChoosingToSaveAsDraft() throws Throwable {
        compose.emailClose();
    }


    @And("^Open draft folder and check the \"([^\"]*)\"$")
    public void openDraftFolderAndCheckThe(String subject) throws Throwable {
        mainPage.openDrafts();
        draftPage.emailTextFind(subject);
    }

    @And("^Send the email$")
    public void sendTheEmail() throws Throwable {
        compose.sendEmail();
    }

    @Then("^Assert that \"([^\"]*)\"$")
    public void assertThat(String text) throws Throwable {
        Assert.assertEquals(draftPage.emailCheck(),text,"No email in Sent folder, please retry");
        profile.signOutOptions().signOut();
        Browser.kill();
    }



}
