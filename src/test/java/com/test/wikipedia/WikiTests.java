package com.test.wikipedia;

import com.test.wikipedia.pages.WikiHomePage;
import com.test.wikipedia.pages.WikiSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.wikipedia.utils.UIConstants;

import java.util.logging.Logger;

public class WikiTests extends AbstractUI {
    private static final Logger LOG = Logger.getLogger(WikiTests.class.getSimpleName());

    private WikiHomePage homePage;
    private WikiSearchResultPage searchResultPage;

    @BeforeClass
    public void preparePage() {
        this.homePage = this.wikiPageFactory.getWikiHomePage();
        this.searchResultPage = this.wikiPageFactory.getWikiSearchResultPage();
    }

    @Test
    public void testSearchSuggestion() {
        LOG.info("VALIDATE PAGE HEADER");
        Assert.assertEquals(this.homePage.getPageHeader(), UIConstants.PageText.HOME_PAGE_HEADER, "Page header does not match !!!");

        LOG.info("SEARCH FOR : \"furry rabbits\" ");
        this.homePage.search(UIConstants.SearchString.SEARCH_STRING_RABBIT);

        LOG.info("VALIDATE THAT THE PAGE SHOWS SUGGESTION");
        Assert.assertTrue(this.searchResultPage.isDidYouMeanSuggestionAvailable(), "\"Did you mean: \" suggestion should be visible !!");

        LOG.info("VALIDATE THE SUGGESTION PRESENTED IS : \"fury rabbit\"");
        Assert.assertEquals(this.searchResultPage.getDidYouMeanSuggestion(), UIConstants.SearchString.SEARCH_STRING_SUGGESTION_RABIT, "Expected suggestion does not match actual!!!");

        LOG.info("CLICK ON SUGGESTION");
        this.searchResultPage.clickOnSuggestion();

        LOG.info("VALIDATE TOTAL NUMBER OF RESULT");
        Assert.assertEquals(this.searchResultPage.getSearchResultCount(), 656, "Result count does not match expected!!");

        LOG.info("CLICK ON FIRST SEARCH RESULT");
    }
}
