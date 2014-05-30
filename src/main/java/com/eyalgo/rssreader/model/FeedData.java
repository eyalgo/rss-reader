package com.eyalgo.rssreader.model;

import java.util.List;

public class FeedData {

    private String feedUrl;
    private List<Item> items;

    public FeedData(String feedUrl, List<Item> items) {
	this.feedUrl = feedUrl;
	this.items = items;
    }

    public String getFeedUrl() {
	return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
	this.feedUrl = feedUrl;
    }

    public List<Item> getItems() {
	return items;
    }

    public void setItems(List<Item> items) {
	this.items = items;
    }
}
