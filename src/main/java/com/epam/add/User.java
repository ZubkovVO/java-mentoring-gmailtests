package com.epam.add;

import com.epam.pf.LoginPage;
import com.epam.pf.ProfilePopup;
import com.epam.pf.RequestPhone;

public class User {

    private String login;
    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void signIn() {
        new LoginPage().openPage().goToLoginPage().enterLogin(login).enterPassword(password).pressNextButton();
    }

    public void noPhone(){
        new RequestPhone().noPhone();
    }

    public void signOut() throws InterruptedException {
        new ProfilePopup().signOutOptions().signOut();
        Thread.sleep(2000);
    }


}
