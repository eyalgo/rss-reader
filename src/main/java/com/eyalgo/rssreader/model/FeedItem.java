package com.eyalgo.rssreader.model;

import java.util.Date;

import com.sun.syndication.feed.synd.SyndEntry;

public class FeedItem {

    private final String title;
    private final String link;
    private final Date publishedDate;

    public FeedItem(String title, String link, Date publishedDate) {
	this.title = title;
	this.link = link;
	this.publishedDate = publishedDate;
    }

    public static FeedItem fromSyndEntry(SyndEntry feedEntry) {
	return new FeedItem(feedEntry.getTitle(), feedEntry.getLink(), feedEntry.getPublishedDate());
    }

    public String getTitle() {
	return title;
    }

    public String getLink() {
	return link;
    }

    public Date getPublishedDate() {
	return publishedDate;
    }
}
