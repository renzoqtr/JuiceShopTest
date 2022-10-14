package com.juiceshop.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private static final String URL = "https://juice-shop.herokuapp.com/";
    private static final By HAMBURGERMENU = By.xpath("//mat-icon[contains(text(), 'menu')]");
    private static final By CARDS = By.xpath("//mat-card");
    private static final By CARDIMG = By.cssSelector("div div img");
    private static final By DISMISSMODAL = By.cssSelector("#mat-dialog-0 button[aria-label='Close Welcome Banner']");

    private static final By ACCEPTCOKIES = By.cssSelector("#cookieconsent\\:desc + div > a");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPage(URL);
    }

    public List<WebElement> getCards() {
        return getElements(CARDS);
    }

    public SideNavBarPage clickOnHamburgerMenu() {
        clickOnElement(HAMBURGERMENU);
        return new SideNavBarPage(this.getDriver());
    }

    public By getCardImageLocator() {
        return CARDIMG;
    }

    public void removeModals() {
        clickOnElement(DISMISSMODAL);
        clickOnElement(ACCEPTCOKIES);
    }

}
