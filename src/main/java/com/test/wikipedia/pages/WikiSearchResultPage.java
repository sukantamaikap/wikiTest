package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;
import com.test.wikipedia.utils.UIConstants;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class WikiSearchResultPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(WikiSearchResultPage.class.getSimpleName());

    public WikiSearchResultPage(Driver browserDriver) {
        super(browserDriver);
    }


    public boolean isDidYouMeanSuggestionAvailable() {
        return this.getElementUtil().findElement(By.xpath(UIConstants.PageElements.SUGGESTED_TITLE_XPATH)).isDisplayed();
    }

    /**
     * Return the suggested string by WikiPedia, while doing a search.
     * This appears as "Did you mean" just below the search box
     * @return
     */
    public String getDidYouMeanSuggestion() {
        final String suggestion = this.getElementUtil().findElement(By.id(UIConstants.PageElements.SUGGESTION_ID)).getText();
        LOG.info("SUGGESTED SEARCH TERM : " + suggestion);
        return suggestion;
    }

    public void clickOnSuggestion() {
        this.getElementUtil().findElement(By.id(UIConstants.PageElements.SUGGESTION_ID)).click();
    }

    public int getSearchResultCount() {
        final String resultCount = this.getElementUtil().findElement(By.xpath(UIConstants.PageElements.SEARCH_RESULT_COUNT_XPTH)).getText();
        LOG.info("TOTAL RESULT COUNT FOUND : " + resultCount);
        int totalResultCount = -1;
        try {
            totalResultCount = Integer.parseInt(resultCount);
        } catch (final NumberFormatException exception) {
            Assert.fail("Invalid number of total search result found : " + resultCount);
        }
        return totalResultCount;
    }

    public void clickOnSearchResult(final int resultIndex) {
        if (resultIndex > 20) {
            Assert.fail("A page contains 20 results, index can not be more than 20");
        }
        final String updatedXPath = UIConstants.PageElements.FIRST_SEARCH_RESULT_XPATH.replace("%s", String.valueOf(resultIndex));
        this.getElementUtil().findElement(By.xpath(updatedXPath)).click();
    }
}
