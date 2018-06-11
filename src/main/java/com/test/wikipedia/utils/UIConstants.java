package com.test.wikipedia.utils;

public final  class UIConstants {

    public static final class PageText {
        public static final String HOME_PAGE_HEADER = "Wikipedia";
        public static final String DID_YOU_MEAN_TEXT = "Did you mean: ";
    }

    public static final class SearchString {
        public static final String SEARCH_STRING_RABBIT = "furry rabbits";
        public static final String SEARCH_STRING_SUGGESTION_RABIT = "fury rabbit";
    }

    public static final class PageElements {
        // home page
        public static final String SEARCH_BOX_ID = "searchInput";
        public static final String SEARCH_XPATH = ".//button[@type='submit']";

        // search result page
        public static final String SUGGESTION_ID = "mw-search-DYM-suggestion";
        public static final String SUGGESTED_TITLE_XPATH = ".//div[@class='searchdidyoumean']";
        public static final String SEARCH_RESULT_COUNT_XPTH = ".//div[@class='results-info']/strong[2]";
        public static final String FIRST_SEARCH_RESULT_XPATH = ".//ul[@class='mw-search-results']/li[%s]";
    }
}
