package com.eyalgo.rssreader.model;

import java.util.List;

public class FeedData {

    private String feedUrl;
    private List<FeedItem> feedItems;

    public FeedData(String feedUrl, List<FeedItem> feedItems) {
	this.feedUrl = feedUrl;
	this.feedItems = feedItems;
    }

    public String getFeedUrl() {
	return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
	this.feedUrl = feedUrl;
    }

    public List<FeedItem> getItems() {
	return feedItems;
    }

    public void setItems(List<FeedItem> feedItems) {
	this.feedItems = feedItems;
    }
}
