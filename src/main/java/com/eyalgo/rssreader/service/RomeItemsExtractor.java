package com.eyalgo.rssreader.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.rometools.fetcher.FeedFetcher;
import org.rometools.fetcher.FetcherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyalgo.rssreader.model.FeedItem;
import com.google.common.collect.Lists;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;

@Service
public class RomeItemsExtractor implements ItemsExtractor {

    private final FeedFetcher fetcher;

    @Autowired
    public RomeItemsExtractor(FeedFetcher fetcher) {
	this.fetcher = fetcher;
    }

    @Override
    public List<FeedItem> extractItems(String feedUrl) {
	try {
	    List<FeedItem> result = Lists.newLinkedList();
	    URL url = new URL(feedUrl);
	    SyndFeed feed = fetcher.retrieveFeed(url);
	    List<SyndEntry> entries = feed.getEntries();
	    for (SyndEntry entry : entries) {
		result.add(new FeedItem(entry.getTitle(), entry.getLink(), entry.getPublishedDate()));
	    }
	    return result;
	} catch (IllegalArgumentException | IOException | FeedException | FetcherException e) {
	    throw new RuntimeException("Error getting feed from " + feedUrl, e);
	}
    }

}
