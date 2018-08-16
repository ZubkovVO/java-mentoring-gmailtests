package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static WebDriver init() {
        /*System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/
        //System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver(getChromeDriverProfile());
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:5557/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static DesiredCapabilities getChromeDriverProfile(){
        HashMap<String, Object> chromePrefs= new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return capabilities;

    }



    public static void kill() {
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
                System.out.println("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }
}
