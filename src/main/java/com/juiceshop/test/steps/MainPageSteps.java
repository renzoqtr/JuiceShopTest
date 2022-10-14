package com.juiceshop.test.steps;

import com.juiceshop.test.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageSteps {

    private final MainPage page;

    public MainPageSteps(WebDriver driver) {
        page = new MainPage(driver);
    }

    public boolean areCardsDisplayed() {
        return page.getCards()
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }

    public boolean areCardsImagesDisplayed() {
        return page.getCards()
                .stream()
                .map(x -> x.findElement(page.getCardImageLocator()))
                .filter(WebElement::isDisplayed)
                .count() > 0;
    }

    public SideNavBareSteps openMenu() {
        page.clickOnHamburgerMenu();
        return new SideNavBareSteps(page.getDriver());
    }

    public JuicePageSteps selectJuice(String juiceName) {
        page.getCards()
                .stream()
                .filter(cardName -> cardName.getText().contains(juiceName))
                .findFirst()
                .ifPresent(WebElement::click);

        return new JuicePageSteps(page.getDriver());
    }


    public void openPage() {
        page.open();
        page.removeModals();
    }

}

