package com.juiceshop.test.steps;

import com.juiceshop.test.pages.ScoreBoardPage;
import org.openqa.selenium.WebDriver;

public class ScoreBoardSteps {

    private final ScoreBoardPage page;

    public ScoreBoardSteps(WebDriver driver) {
        page = new ScoreBoardPage(driver);
    }

    public boolean isTableDisplayed() {
        page.waitUntilTableIsVisible();
        return page.isTableDisplayed();
    }

}
