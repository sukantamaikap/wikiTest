package com.test.wikipedia.drivers;

import com.test.wikipedia.utils.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public final class DriverFactory {
    private Driver driver;
    private WebDriver webDriver  = null;
    private static DriverFactory DRIVER_FACTORY;

    private DriverFactory() {
        // add case
        try {
            if (ConfigUtil.getBrowser().equalsIgnoreCase("firefox")) {
                this.driver = new FirefoxDriverImpl();
            } else if (ConfigUtil.getBrowser().equalsIgnoreCase("chrome")) {
                this.driver = new ChromeDriverImpl();
            } else {
                Assert.fail("Unknown browser option, please check config.properties");
                // default to FF
            }
        } catch (IOException e) {
            Assert.fail("Properties file does not exist!!");
        }
    }

    /**
     * Get the interface {@link Driver}, the common interface for all browser driver.
     * @return {@link Driver} interface
     */
    public Driver getDriver() {
        return this.driver;
    }

    /**
     *
     * @return instance of {@link WebDriver} for the chosen browser.
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * Factory - supposed to be singleton.
     * @return instance of {@link DriverFactory}
     */
    public static DriverFactory getInstance() {
        if (DRIVER_FACTORY == null) {
            return new DriverFactory();
        }
        return DRIVER_FACTORY;
    }
}
