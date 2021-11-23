package com.spacebase.qa.pages;

import com.spacebase.qa.base.BaseTest;
import com.spacebase.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Page objects and methods for Sign in Page
 * @Author: PK
 */
public class SignInPage extends BaseTest {
    WebDriver driver;
    @FindBy(id="id_username")
    private WebElement email;


    @FindBy(id="id_password")
    private WebElement password;

    @FindBy(id="login-button")
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

}
