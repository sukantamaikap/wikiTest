package com.test.wikipedia;

import com.test.wikipedia.drivers.DriverFactory;
import com.test.wikipedia.pages.WikiPageFactory;
import com.test.wikipedia.utils.ConfigUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.logging.Logger;

public class AbstractUI {
    private static final Logger LOG = Logger.getLogger(AbstractUI.class.getSimpleName());

    protected DriverFactory driverFactory;
    protected WikiPageFactory wikiPageFactory;

    /**
     * Start browser and prepare environment
     */
    @BeforeTest
    public void prepEnvironment() throws IOException {
        if (this.driverFactory != null) {
            LOG.info("WE NEED TO CLOSE ANY DORMANT BROWSER SESSION");
            this.driverFactory.getDriver().quitDriver();
            this.driverFactory = null;
        }

        LOG.info("START A NEW DRIVER SESSION");
        this.driverFactory = DriverFactory.getInstance();

        LOG.info("INIT PAGE");
        this.wikiPageFactory = new WikiPageFactory(this.driverFactory.getDriver());

        this.driverFactory.getDriver().getWebDriver().navigate().to(ConfigUtil.getBaseUrl());

        LOG.info("MAXIMIZE WINDOW");
        this.driverFactory.getDriver().getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void shutDown() throws Exception {
        this.driverFactory.getDriver().quitDriver();
    }
}
