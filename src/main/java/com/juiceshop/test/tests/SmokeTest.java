package com.juiceshop.test.tests;


import com.juiceshop.test.driver.DriverSetup;
import com.juiceshop.test.pages.GitHubExternalPage;
import com.juiceshop.test.steps.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SmokeTest {

    private WebDriver driver;
    private SoftAssertions softAssertions;

    @Before
    public void setUp() {
        driver = DriverSetup.getDriver("Chrome");
        softAssertions = new SoftAssertions();
    }

    @Test
    public void MainPageTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        softAssertions.assertThat(mainPage.areCardsDisplayed()).isTrue();
        softAssertions.assertThat(mainPage.areCardsImagesDisplayed()).isTrue();
    }

    @Test
    public void MenuTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        SideNavBareSteps sideNavMenu = mainPage.openMenu();
        softAssertions.assertThat(sideNavMenu.areMenuItemsDisplayed()).isTrue();
    }

    @Test
    public void gitHubTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        SideNavBareSteps sideNavMenu = mainPage.openMenu();
        GitHubExternalPage gitHubPage = sideNavMenu.clickOnGitHubMenuItem();
        softAssertions.assertThat(gitHubPage.isCodeTabDisplayed()).isTrue();
    }

    @Test
    public void photoWallTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        SideNavBareSteps sideNavMenu = mainPage.openMenu();
        PhotoWallSteps photoWall = sideNavMenu.clickOnPhotoWallMenuItem();
        softAssertions.assertThat(photoWall.areImagesDisplayed()).isTrue();
    }

    @Test
    public void aboutUsTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        SideNavBareSteps sideNavMenu = mainPage.openMenu();
        AboutUsSteps aboutUs = sideNavMenu.clickOnAboutUsMenuItem();
        softAssertions.assertThat(aboutUs.hasContent()).isTrue();
    }

    @Test
    public void scoreBoardTest() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        SideNavBareSteps sideNavMenu = mainPage.openMenu();
        ScoreBoardSteps scoreBoard = sideNavMenu.clickOnScoreBoardMenuItem();
        softAssertions.assertThat(scoreBoard.isTableDisplayed()).isTrue();
    }

    @After
    public void tearDown() {
        driver.quit();
        softAssertions.assertAll();
    }

}
