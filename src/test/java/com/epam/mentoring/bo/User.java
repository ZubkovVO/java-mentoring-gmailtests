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
    public void noPhone(){
        new RequestPhone().noPhone();
    }
    */
}
