package com.spacebase.qa;

import com.spacebase.qa.base.BaseTest;
import com.spacebase.qa.pages.LandingPage;
import com.spacebase.qa.pages.SignInPage;
import com.spacebase.qa.util.ConfigReader;
import com.spacebase.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;
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
    ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();

    @BeforeMethod
    public void user_navigates_to_website() {
        driver = base.initialize();
        landingPage = new LandingPage(driver);
        signInPage = new SignInPage(driver);
        log.info("Initial setup completed");
        String url = prop.getProperty("url");
        landingPage.navigateToURL(url);
   }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test (priority=0)
    public void test_invoice_is_correct(){
       System.out.println("***TEST 001***");
       String username= prop.getProperty("user");
       String password = prop.getProperty("pass");
       signInPage.signIn(username,password);
        TestUtil.sleepForNSeconds(2);

        landingPage.clickSeeFullHistory();
        TestUtil.sleepForNSeconds(2);
        Assert.assertEquals(landingPage.getActualPrice(),landingPage.getExpectedPrice());
    }

}
