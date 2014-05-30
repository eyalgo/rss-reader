package com.eyalgo.rssreader.matchers;

import java.util.List;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.Item;

public class Matchers {
    public static Matcher<FeedData> sameFeedData(String expectedFeedUrl, List<Item> expectedItems) {
	return new FeedDataMetcher(expectedFeedUrl, expectedItems);
    }

    private final static class FeedDataMetcher extends CustomTypeSafeMatcher<FeedData> {
	private final String expectedFeedUrl;
	private final List<Item> expectedItems;

	public FeedDataMetcher(String expectedFeedUrl, List<Item> expectedItems) {
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
