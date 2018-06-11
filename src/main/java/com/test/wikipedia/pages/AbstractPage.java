package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;
import com.test.wikipedia.utils.PageElementUtil;

public class AbstractPage {
    private Driver browserDriver;
    private PageElementUtil elementUtil;

    public AbstractPage(final Driver browserDriver) {
        this.browserDriver = browserDriver;
        this.elementUtil = new PageElementUtil(this.browserDriver);
    }

    public PageElementUtil getElementUtil() {
        return this.elementUtil;
    }

    public Driver grtDriver() {
        return this.browserDriver;
    }
}
