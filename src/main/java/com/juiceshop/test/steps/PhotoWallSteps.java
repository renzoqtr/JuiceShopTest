package com.juiceshop.test.steps;

import com.juiceshop.test.pages.PhotoWallPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhotoWallSteps {

    private PhotoWallPage page ;


    public PhotoWallSteps(WebDriver driver){
        page = new PhotoWallPage(driver);
    }

    public boolean areImagesDisplayed(){
        return page.getImages()
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }



}
