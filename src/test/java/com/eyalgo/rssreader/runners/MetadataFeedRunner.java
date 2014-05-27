package com.eyalgo.rssreader.runners;

import java.io.File;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

public class MetadataFeedRunner {

    public MetadataFeedRunner() {
    }
    
    private void printFeed() throws Exception {
	SyndFeedInput input = new SyndFeedInput();
	URL url = this.getClass().getResource("cnn.small");
	System.out.println(url);
	File file = new File(url.toURI());
	SyndFeed feed = input.build(file);
	@SuppressWarnings("unchecked")
	List<SyndEntry> entries = feed.getEntries();
	for (SyndEntry entry : entries) {
	    System.out.println(entry.getTitle());
	    System.out.println(entry.getLink());
	    System.out.println(entry.getPublishedDate());
	    System.out.println();
	}
    }

    public static void main(String[] args) throws Exception {
	new MetadataFeedRunner().printFeed();
    }

}
