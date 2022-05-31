package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage extends BasePage {


    private static final By CONTENT = By.cssSelector("p.text-justify");
    private static final By SLIDESHOW = By.cssSelector("div.slideshow-container");

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean IsContentDisplayed() {
        return isDisplayed(CONTENT);
    }

    public void waitForSlideShowBeVisible(){
        waitUntilVisible(SLIDESHOW);
    }

    public boolean IsSlideShowDisplayed() {
        //section slideshow
        return isDisplayed(SLIDESHOW);
    }

}
