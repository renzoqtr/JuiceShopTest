package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubExternalPage extends BasePage {

    private static final By CODETAB = By.id("code-tab");

    public GitHubExternalPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCodeTabDisplayed() {
        return isDisplayed(CODETAB);
    }

}
