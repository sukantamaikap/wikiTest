package com.test.wikipedia.drivers;

import com.test.wikipedia.utils.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public final class FirefoxDriverImpl implements Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public FirefoxDriverImpl() throws IOException {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, ConfigUtil.getGeckoDriver());
        this.webDriver = new org.openqa.selenium.firefox.FirefoxDriver();
        this.webDriverWait = new WebDriverWait(this.webDriver, WEB_DRIVER_WAIT);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    public void quitDriver() {
        this.webDriver.quit();
    }
}
