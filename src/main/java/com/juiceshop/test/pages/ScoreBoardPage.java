package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScoreBoardPage extends BasePage {

    private static final By TABLE = By.cssSelector("mat-card mat-table");

    public ScoreBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTableDisplayed() {
        return isDisplayed(TABLE);
    }

    public void waitUntilTableIsVisible() {
        waitUntilVisible(TABLE);
    }

}
