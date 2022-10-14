package com.juiceshop.test.steps;

import com.juiceshop.test.pages.GitHubExternalPage;
import com.juiceshop.test.pages.SideNavBarPage;
import org.openqa.selenium.WebDriver;

public class SideNavBareSteps {

    private final SideNavBarPage page;

    public SideNavBareSteps(WebDriver driver) {
        page = new SideNavBarPage(driver);
    }

    public boolean areMenuItemsDisplayed() {
        return page.isAboutUsDisplayed() && page.isGitHubDisplayed()
                && page.isPhotoWallDisplayed() && page.isScoreBoardDisplayed();
    }

    public GitHubExternalPage clickOnGitHubMenuItem() {
        return page.clickOnGitHub();
    }

    public PhotoWallSteps clickOnPhotoWallMenuItem() {
        page.clickOnPhotoWall();
        return new PhotoWallSteps(page.getDriver());
    }

    public AboutUsSteps clickOnAboutUsMenuItem() {
        page.clickOnAboutUs();
        return new AboutUsSteps(page.getDriver());
    }

    public ScoreBoardSteps clickOnScoreBoardMenuItem() {
        page.clickOnScoreBoard();
        return new ScoreBoardSteps(page.getDriver());
    }

}
