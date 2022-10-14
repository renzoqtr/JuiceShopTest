package com.juiceshop.test.tests;

import com.juiceshop.test.driver.DriverSetup;
import com.juiceshop.test.steps.JuicePageSteps;
import com.juiceshop.test.steps.MainPageSteps;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class RegressionTest {

    private WebDriver driver;
    private SoftAssertions softAssertions;

    @Before
    public void setUp() {
        driver = DriverSetup.getDriver("Chrome");
        softAssertions = new SoftAssertions();
    }

    @Test
    public void selectJuice() {
        MainPageSteps mainPage = new MainPageSteps(driver);
        mainPage.openPage();
        JuicePageSteps juicePage = mainPage.selectJuice("Lemon Juice");
        softAssertions.assertThat(juicePage.isJuicyPictureDisplayed()).isTrue();
        juicePage.CloseModal();
        softAssertions.assertThat(juicePage.isJuicyPictureDisplayed()).isFalse();
    }

    @After
    public void tearDown() {
        driver.quit();
        softAssertions.assertAll();
    }

}
