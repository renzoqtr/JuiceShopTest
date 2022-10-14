package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JuicePage extends BasePage {

    private static final By CLOSEBUTTON = By.cssSelector("button[aria-label='Close Dialog']");
    private static final By JUICEPIC = By.cssSelector("mat-dialog-container img");

    private static final By MODAL = By.cssSelector("mat-dialog-container[role='dialog']");


    public JuicePage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCloseButton() {
        clickOnElement(CLOSEBUTTON);
    }

    public boolean isJuicyPictureDisplayed() {
        return isDisplayed(JUICEPIC);
    }

    public void waitModalDisappears() {
        waitUntilElementIsNotPresent(MODAL);
    }
}
