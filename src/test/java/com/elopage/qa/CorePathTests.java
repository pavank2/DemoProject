package com.elopage.qa;

import com.elopage.qa.base.BaseTest;
import com.elopage.qa.pages.LandingPage;
import com.elopage.qa.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.util.logging.Logger;
/**
 * Two E2E Tests for the two core paths for the Checkout functionality
 * Test 1: User signs in, searches for two products, selects the cheapest available ones, adds them to cart and verifies the amount
 * Test 2: Searches for products first, selects a single product, adds them to cart and verifies user sign in during checkout
 * @Author: PK
 *
 */
public class CorePathTests extends BaseTest {
    BaseTest base = new BaseTest();
    WebDriver driver;
    LandingPage landingPage;
    SignInPage signInPage;

    static Logger log = Logger.getLogger(CorePathTests.class.getName());

//    @BeforeClass
//    public void setup() throws Throwable {
//
//
//    }

    @BeforeMethod
    public void user_navigates_to_website() {
        driver = base.initialize();
        landingPage = new LandingPage(driver);
        signInPage = new SignInPage(driver);
        log.info("Initial setup completed");
        landingPage.navigateToURL("http://elopage.com/en/");
   }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test (priority=0)
    public void test_signin(){
       System.out.println("***TEST 001***");
       landingPage.clickLoginBtn();
       signInPage.signIn("getsugarasengan@gmail.com","Registerme1!");

   }

    @Test (priority=0)
    public void test_signin_wrong_creds(){
        System.out.println("***TEST 001***");
        landingPage.clickLoginBtn();
        signInPage.signIn("getsugarasengan@gmail.com","temp1234");

    }


}
