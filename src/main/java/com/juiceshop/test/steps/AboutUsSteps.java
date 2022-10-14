package com.juiceshop.test.steps;

import com.juiceshop.test.pages.AboutUsPage;
import org.openqa.selenium.WebDriver;

public class AboutUsSteps {

    private final AboutUsPage page;

    public AboutUsSteps(WebDriver driver) {
        page = new AboutUsPage(driver);
    }

    public boolean hasContent() {
        page.waitForSlideShowBeVisible();
        return page.IsContentDisplayed()
                && page.IsSlideShowDisplayed();
    }

}
