package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideNavBarPage extends BasePage {


    private static final By ABOUTUS = By.cssSelector("a[aria-label='Go to about us page']");
    private static final By PHOTOWALL = By.cssSelector("a[aria-label='Go to photo wall']");
    private static final By SCOREBOARD = By.cssSelector("a[aria-label='Open score-board']");
    private static final By GITHUB = By.cssSelector("a[aria-label='Go to OWASP Juice Shop GitHub page']");


    public SideNavBarPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAboutUs() {
        clickOnElement(ABOUTUS);
    }

    public void clickOnPhotoWall() {
        clickOnElement(PHOTOWALL);
    }

    public void clickOnScoreBoard() {
        clickOnElement(SCOREBOARD);
    }

    public GitHubExternalPage clickOnGitHub() {
        clickOnElement(GITHUB);
        return new GitHubExternalPage(this.getDriver());
    }

    public boolean isAboutUsDisplayed() {
        return isDisplayed(ABOUTUS);
    }

    public boolean isPhotoWallDisplayed() {
        return isDisplayed(PHOTOWALL);
    }

    public boolean isGitHubDisplayed() {
        return isDisplayed(GITHUB);
    }

    public boolean isScoreBoardDisplayed() {
        return isDisplayed(ABOUTUS);
    }

}
