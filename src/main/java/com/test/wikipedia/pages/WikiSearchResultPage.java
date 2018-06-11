package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;
import com.test.wikipedia.utils.UIConstants;
import org.openqa.selenium.By;

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
}
