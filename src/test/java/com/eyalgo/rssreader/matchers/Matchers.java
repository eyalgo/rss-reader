package com.eyalgo.rssreader.matchers;

import java.util.Date;
import java.util.List;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.FeedItem;

public class Matchers {
    public static Matcher<FeedData> sameFeedData(String expectedFeedUrl, List<FeedItem> expectedItems) {
	return new FeedDataMetcher(expectedFeedUrl, expectedItems);
    }

    public static Matcher<FeedItem> sameFeedItem(String title, String link, Date date) {
	return new FeedItemMetcher(title, link, date);
    }

    private final static class FeedItemMetcher extends CustomTypeSafeMatcher<FeedItem> {

	private final String expectedTitle;
	private final String expectedLink;
	private final Date expectedDate;

	private FeedItemMetcher(String title, String link, Date date) {
	    super("a FeedItem Matcher");
	    this.expectedTitle = title;
	    this.expectedLink = link;
	    this.expectedDate = date;
	}

	@Override
	protected boolean matchesSafely(FeedItem feedItem) {
	    if (!feedItem.getTitle().equals(expectedTitle)) {
		return false;
	    }
	    if (!feedItem.getLink().equals(expectedLink)) {
		return false;
	    }
	    if (!feedItem.getPublishedDate().equals(expectedDate)) {
		return false;
	    }
	    return true;
	}

    }

    private final static class FeedDataMetcher extends CustomTypeSafeMatcher<FeedData> {
	private final String expectedFeedUrl;
	private final List<FeedItem> expectedItems;

	private FeedDataMetcher(String expectedFeedUrl, List<FeedItem> expectedItems) {
	    super("a FeedData Matcher");
	    this.expectedFeedUrl = expectedFeedUrl;
	    this.expectedItems = expectedItems;
	}

	@Override
	protected boolean matchesSafely(FeedData feedData) {
	    if (!feedData.getFeedUrl().equals(expectedFeedUrl)) {
		return false;
	    }
	    if (!feedData.getItems().equals(expectedItems)) {
		return false;
	    }
	    return true;
	}

    }

}
