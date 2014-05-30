package com.eyalgo.rssreader.dal;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.Item;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Repository
public class InMemoryItemsRepository implements ItemsRepository {
    private final Map<String, List<Item>> db;

    public InMemoryItemsRepository() {
	db = Maps.newHashMap();
    }

    @Override
    public void save(FeedData data) {
	db.put(hasKeyForUrl(data.getFeedUrl()), data.getItems());
    }

    public List<Item> getAll() {
	List<Item> result = Lists.newLinkedList();
	for (List<Item> itemsForUrl : db.values()) {
	    result.addAll(itemsForUrl);
	}
	return result;
    }
    
    private String hasKeyForUrl(String feedUrl) {
	return feedUrl;
    }

}
