package com.epam.add;

import com.epam.pf.LoginPage;
import com.epam.pf.PasswordPage;
import com.epam.pf.ProfilePopup;

public class User {

    private String login;
    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void signIn(){
        new LoginPage().openPage().fillLoginInput(login).pressNextButton();
        new PasswordPage().fillPasswordInput(password).pressNextButton();
    }

    public void signOut() throws InterruptedException {
        new ProfilePopup().signOutOptions().signOut();
        Thread.sleep(2000);
    }


}
