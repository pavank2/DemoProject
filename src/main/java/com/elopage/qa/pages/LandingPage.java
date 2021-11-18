package com.elopage.qa.pages;

import com.elopage.qa.base.BaseTest;
import com.elopage.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    @FindBy(css="a[href*='sign_in']")
    private WebElement loginBtn;

    @FindBy(css="[id*='DeclineAll']")
    private List<WebElement> cookies;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToURL(String url) {

        driver.get(url);
        if (cookies.size() >0)
            cookies.get(0).click();
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }



}
