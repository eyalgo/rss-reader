package com.eyalgo.rssreader.model;

import java.util.Date;

import com.sun.syndication.feed.synd.SyndEntry;

public class Item {

    private final String title;
    private final String link;
    private final Date publishedDate;

    public Item(String title, String link, Date publishedDate) {
	this.title = title;
	this.link = link;
	this.publishedDate = publishedDate;
    }

    public static Item fromSyndEntry(SyndEntry feedEntry) {
	return new Item(feedEntry.getTitle(), feedEntry.getLink(), feedEntry.getPublishedDate());
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
