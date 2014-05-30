package com.eyalgo.rssreader.dal;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.FeedItem;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Repository
public class InMemoryItemsRepository implements ItemsRepository {
    private final Map<String, List<FeedItem>> db;

    public InMemoryItemsRepository() {
	db = Maps.newHashMap();
    }

    @Override
    public void save(FeedData data) {
	db.put(hasKeyForUrl(data.getFeedUrl()), data.getItems());
    }

    @Override
    public List<FeedItem> findAll() {
	List<FeedItem> result = Lists.newLinkedList();
	for (List<FeedItem> itemsForUrl : db.values()) {
	    result.addAll(itemsForUrl);
	}
	return result;
    }
    
    private String hasKeyForUrl(String feedUrl) {
	return feedUrl;
    }

}
