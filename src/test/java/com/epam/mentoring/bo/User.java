package com.epam.mentoring.bo;

import com.epam.mentoring.pages.LoginPage;
import com.epam.mentoring.pages.ProfilePopup;
import com.epam.mentoring.pages.RequestPhone;

public class User {

    private static final String LOGIN = "selenium.tester80@yandex.ru";
    private static final String PASSWORD = "Administratum41";

    public String getLogin() { return LOGIN; }

    public String getPassword() { return PASSWORD; }

    /*
    public void signIn() {
        new LoginPage().openPage().goToLoginPage().login(login).enterPassword(password).pressNextButton();
    }

    public void signInToDisk() {
        new LoginPage().openDiskPage().diskLogin().enterLogin(login).enterPassword(password).pressNextButton();
    }

    public void noPhone(){
        new RequestPhone().noPhone();
    }

    public void signOut() {
        new ProfilePopup().signOutOptions().signOut();
    }

    public void signOutDisk() throws InterruptedException {
        new ProfilePopup().signOutDiskOptions().signOutDisk();
    }
    */
}
