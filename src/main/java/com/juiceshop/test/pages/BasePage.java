package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait doWait;

    private static final int TIMELIMIT = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        doWait = new WebDriverWait(driver, Duration.ofSeconds(TIMELIMIT));
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

    public void waitUntilVisible(By locator){
        doWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator) {
        return doWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean isDisplayed(By locator) {
        return doWait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
