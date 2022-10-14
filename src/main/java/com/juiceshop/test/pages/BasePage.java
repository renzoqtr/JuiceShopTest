package com.juiceshop.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait doWait;
    private final FluentWait<WebDriver> waitFluently;


    private static final int TIMELIMIT = 10;
    private static final int TIMELIMITSHORT = 5;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        doWait = new WebDriverWait(driver, Duration.ofSeconds(TIMELIMIT));
        waitFluently = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMELIMITSHORT))
                .pollingEvery(Duration.ofSeconds(1));
    }

    public void openPage(String url) {
        this.driver.navigate().to(url);
    }

    public void clickOnElement(By locator) {
        doWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator) {
        return doWait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public void writeOnField(By locator, String text) {
        WebElement field = doWait.until(ExpectedConditions.elementToBeClickable(locator));
        field.click();
        field.clear();
        field.sendKeys(text);
    }

    public void waitUntilVisible(By locator) {
        doWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator) {
        return doWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean isDisplayed(By locator) {
        boolean displayed;
        try {
            displayed = waitFluently.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
        } catch (NoSuchElementException ex) {
            displayed = false;
        }
        return displayed;
    }

    public void waitUntilElementIsNotPresent(By locator) {
        try {
            doWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
        } catch (TimeoutException ex) {

        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
