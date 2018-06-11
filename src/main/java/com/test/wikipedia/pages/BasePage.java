package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;
import com.test.wikipedia.utils.PageElementUtil;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private Driver browserDriver;
    private PageElementUtil elementUtil;
    private WebDriver webDriver;

    public BasePage(final Driver browserDriver) {
        this.browserDriver = browserDriver;
        this.elementUtil = new PageElementUtil(this.browserDriver);
        this.webDriver = this.grtDriver().getWebDriver();
    }

    public PageElementUtil getElementUtil() {
        return this.elementUtil;
    }

    public Driver grtDriver() {
        return this.browserDriver;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
