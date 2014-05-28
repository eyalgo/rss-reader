package com.eyalgo.rssreader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FeedReciever {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedReciever.class);
    public FeedReciever() {
    }

    public void addFeed(String feedUrl) {
	LOGGER.info(String.format("going to add feed: %s", feedUrl));
    }

}
