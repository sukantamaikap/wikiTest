package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;

import java.util.logging.Logger;

public final class WikiPageFactory {
    private static final Logger LOG = Logger.getLogger(WikiPageFactory.class.getSimpleName());

    private Driver browserDriver;

    public WikiPageFactory(final Driver browserDriver) {
        this.browserDriver = browserDriver;
    }

    public WikiHomePage getWikiHomePage() {
        LOG.info("INSTANTIATING WIKI HOME PAGE OBJECT");
        return new WikiHomePage(this.browserDriver);
    }

    public WikiSearchResultPage getWikiSearchResultPage() {
        LOG.info("INSTANTIATING WIKI SEARCH RESULT PAGE OBJECT");
        return new WikiSearchResultPage(this.browserDriver);
    }
}
