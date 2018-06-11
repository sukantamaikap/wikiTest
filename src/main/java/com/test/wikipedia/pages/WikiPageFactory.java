package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;

public final class WikiPageFactory {
    private Driver browserDriver;

    public WikiPageFactory(final Driver browserDriver) {
        this.browserDriver = browserDriver;
    }

    public WikiHomePage getWikiHomePage() {
        return new WikiHomePage(this.browserDriver);
    }
}
