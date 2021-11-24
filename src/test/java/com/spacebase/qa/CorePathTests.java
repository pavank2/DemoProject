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
 *
 * One automated test which checks if the amount on the main payments page and the invoice
 * in the full history page is matching exactly.
 * This test case FAILS currently due to the bug on the UI.
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
