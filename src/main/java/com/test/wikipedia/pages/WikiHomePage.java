package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;

import java.util.logging.Logger;

public class WikiHomePage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(WikiHomePage.class.getSimpleName());

    private static final String SEARCH_BOX_ID = "searchInput";

    public WikiHomePage(final Driver browserDriver) {
        super(browserDriver);
    }

    public void search(final String searchTerm) {
        LOG.info("WILL SEARCH FOR SPECIFIED TERM : " + searchTerm);
    }

    public String getPageHeader() {
        return this.grtDriver().getWebDriver().getTitle();
    }

}
