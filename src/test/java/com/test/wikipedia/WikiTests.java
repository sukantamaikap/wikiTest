package com.test.wikipedia;

import com.test.wikipedia.pages.WikiHomePage;
import com.test.wikipedia.pages.WikiSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class WikiTests extends AbstractUI {
    private static final Logger LOG = Logger.getLogger(WikiTests.class.getSimpleName());
    private WikiHomePage homePage;
    private WikiSearchResultPage searchResultPage;

    @BeforeClass
    public void preparePage() {
        this.homePage = this.bookingPageFactory.getWikiHomePage();
    }

    @Test
    public void testWikiHomePageTitle() {
        LOG.info("VALIDATE PAGE HEADER");
        Assert.assertEquals(this.homePage.getPageHeader(), "Wikipedia", "Page header does not match !!!");
    }

    @Test
    public void testSearchSuggestion() {
        final String invalidSearchTerm = "furry rabbits";

        LOG.info("SEARCH FOR : \"furry rabbits\" ");
        this.homePage.search(invalidSearchTerm);
    }
}
