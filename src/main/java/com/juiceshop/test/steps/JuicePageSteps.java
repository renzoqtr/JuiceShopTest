package com.juiceshop.test.steps;

import com.juiceshop.test.pages.JuicePage;
import org.openqa.selenium.WebDriver;

public class JuicePageSteps {

    private final JuicePage page;

    public JuicePageSteps(WebDriver driver) {
        page = new JuicePage(driver);
    }

    public void CloseModal() {
        page.clickOnCloseButton();
        page.waitModalDisappears();
    }

    public boolean isJuicyPictureDisplayed() {
        return page.isJuicyPictureDisplayed();
    }

}
