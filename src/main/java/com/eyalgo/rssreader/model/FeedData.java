package com.eyalgo.rssreader.model;

import java.util.List;

public class FeedData {

    private final String feedUrl;
    private final List<FeedItem> items;

    public FeedData(String feedUrl, List<FeedItem> feedItems) {
	this.feedUrl = feedUrl;
	this.items = feedItems;
    }

    public String getFeedUrl() {
	return feedUrl;
    }

    public List<FeedItem> getItems() {
	return items;
    }
}
