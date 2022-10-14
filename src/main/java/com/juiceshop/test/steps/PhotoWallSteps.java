package com.juiceshop.test.steps;

import com.juiceshop.test.pages.PhotoWallPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class PhotoWallSteps {

    private final PhotoWallPage page;
    private final FluentWait<WebDriver> waitFluently;

    public PhotoWallSteps(WebDriver driver) {
        page = new PhotoWallPage(driver);

        waitFluently = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    private void waitUntilImagesAreLoaded() {
        List<WebElement> images = page.getImages();
        waitFluently.until(ExpectedConditions.visibilityOf(images.get(0)));
    }

    public boolean areImagesDisplayed() {
        waitUntilImagesAreLoaded();
        return page.getImages()
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }

}
