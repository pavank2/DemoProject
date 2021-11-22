package com.elopage.qa.pages;

import com.elopage.qa.base.BaseTest;
import com.elopage.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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

    @FindBy(xpath="//div[contains(text(),'Invalid email or password')]")
    private List<WebElement> signInError;

    @FindBy(xpath="//div[contains(text(),'Hello,')]")
    private List<WebElement> signInConfirm;


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

    public boolean invalidCredWarningVisible(){
        TestUtil.sleepForNSeconds(1);
        return signInError.size() > 0;
    }
    public boolean signInConfirmed(){
        TestUtil.sleepForNSeconds(1);
        return signInConfirm.size() > 0;
    }

}
