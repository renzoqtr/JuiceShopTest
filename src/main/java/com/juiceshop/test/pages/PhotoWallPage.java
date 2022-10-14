package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PhotoWallPage extends BasePage {

    private static final By IMAGES = By.cssSelector("img.image");

    public PhotoWallPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getImages() {
        return getElements(IMAGES);
    }

}
