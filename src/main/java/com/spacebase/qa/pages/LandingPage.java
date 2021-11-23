package com.spacebase.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    @FindBy(id="price-after-tax")
    private WebElement expectedPrice;

    @FindBy(xpath="//div[@id='reveal-hire-accounting']//table//tr[2]//td[2]")
    private WebElement actualPrice;

    @FindBy(className="cmp-bookingrecap-button")
    private WebElement seeFullHistory;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void clickSeeFullHistory() {
         seeFullHistory.click();
    }

    public String getActualPrice(){
       return actualPrice.getText();
    }

    public String getExpectedPrice(){
       return expectedPrice.getText();
    }
}
