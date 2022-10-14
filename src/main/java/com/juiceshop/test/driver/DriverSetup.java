package com.juiceshop.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    public static WebDriver getDriver(String Browser) {
        WebDriver driver;
        switch (Browser) {
            case "Chrome" -> {
                driver = new ChromeDriver();
            }
            case "Firefox" -> {
                driver = new FirefoxDriver();
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--ignore-certificate-errors");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }


}
