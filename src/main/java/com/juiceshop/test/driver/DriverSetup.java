package com.juiceshop.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    public static WebDriver getDriver(String Browser) {
        WebDriver driver;
        switch (Browser) {
            case "Chrome": {
                driver = new ChromeDriver();
            }
            break;
            case "Firefox": {
                driver = new FirefoxDriver();
            }
            break;
            default: {
                driver = new ChromeDriver();
            }
            break;
        }
        return driver;
    }


}
