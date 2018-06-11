package com.test.wikipedia.drivers;

import com.test.wikipedia.utils.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public final class ChromeDriver implements Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public ChromeDriver() throws IOException {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, ConfigUtil.getChromeDriver());

        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        this.webDriver = new org.openqa.selenium.chrome.ChromeDriver(options);
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
