package com.epam.mentoring.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver createWebDriver(String driverType) throws MalformedURLException {
        if (driverType.equalsIgnoreCase("Firefox")) {
            return new RemoteWebDriver(new URL("http://127.0.0.1:5559/wd/hub"), new FirefoxOptions());
        } else if (driverType.equalsIgnoreCase("Chrome")) {
            return new RemoteWebDriver(new URL("http://127.0.0.1:5557/wd/hub"), DesiredCapabilities.chrome());
        } else {
            return null;
        }
    }
}

/*    public static WebDriver createWebDriver(String driverType, MutableCapabilities options) throws MalformedURLException {
        if (driverType.equalsIgnoreCase("Firefox")){
            return new RemoteWebDriver(new URL("http://127.0.0.1:5559/wd/hub"), new FirefoxOptions());
        } else return null;
    }*/