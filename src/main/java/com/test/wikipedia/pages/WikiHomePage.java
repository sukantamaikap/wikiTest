package com.test.wikipedia.pages;

import com.test.wikipedia.drivers.Driver;
import com.test.wikipedia.utils.UIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class WikiHomePage extends BasePage {
    private static final Logger LOG = Logger.getLogger(WikiHomePage.class.getSimpleName());

    public WikiHomePage(final Driver browserDriver) {
        super(browserDriver);
    }

    public void search(final String searchTerm) {
        LOG.info("WILL SEARCH FOR SPECIFIED TERM : " + searchTerm);
        final WebElement webElement = this.getElementUtil().findElement(By.id(UIConstants.PageElements.SEARCH_BOX_ID));
        webElement.clear();
        webElement.sendKeys(searchTerm);

        LOG.info("HIT SEARCH");
        this.getElementUtil().findElement(By.xpath(UIConstants.PageElements.SEARCH_XPATH)).click();
    }

    public String getPageHeader() {
        return this.getWebDriver().getTitle();
    }

}
