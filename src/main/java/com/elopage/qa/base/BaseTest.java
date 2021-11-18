package com.elopage.qa.base;

import com.elopage.qa.factory.DriverFactory;
import com.elopage.qa.util.ConfigReader;
import com.elopage.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    DriverFactory driverFactory;
    public WebDriver driver;
    Properties prop;
    private ConfigReader configReader;

    public WebDriver initialize() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();

      //  System.setProperty("webdriver.chrome.driver", "C://Users//PK//Downloads//chromedriver.exe");
        driver = driverFactory.init_driver(browserName);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;

    }

}
/*************Code snippet for Remotewebdriver to run on Docker and K8S ************
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-automation");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

  //    Docker config:  "http://10.60.28.135:4444"
        try {
            driver = new RemoteWebDriver(new URL("http://3.108.249.101:32237/wd/hub"),options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

******************************************************/