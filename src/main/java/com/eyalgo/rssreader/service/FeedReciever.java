package com.eyalgo.rssreader.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyalgo.rssreader.dal.ItemsRepository;
import com.eyalgo.rssreader.model.Item;

@Service
public class FeedReciever {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedReciever.class);
    private ItemsExtractor extractor;
    private ItemsRepository repository;

    @Autowired
    public FeedReciever(ItemsExtractor extractor, ItemsRepository repository) {
	this.extractor = extractor;
	this.repository = repository;
    }

    public void addFeed(String feedUrl) {
	LOGGER.info(String.format("going to add feed: %s", feedUrl));
	List<Item> items = extractor.extractItems(feedUrl);
	repository.saveItems(items);
    }
}
