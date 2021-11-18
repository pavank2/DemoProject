package com.elopage.qa.pages;

import com.elopage.qa.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Page objects and methods for Sign in Page
 * @Author: PK
 */
public class SignInPage extends BaseTest {
    WebDriver driver;
    @FindBy(id="email")
    private WebElement email;


    @FindBy(id="password")
    private WebElement password;

    @FindBy(css="button[type='submit']")
    private WebElement signInButton;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn(String mail,String pass){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        email.sendKeys(mail);
        password.sendKeys(pass);
        signInButton.click();

    }

    //public boolean checkUserSignedOut(){
    //    return continueButton.isDisplayed();
 //   }

}
