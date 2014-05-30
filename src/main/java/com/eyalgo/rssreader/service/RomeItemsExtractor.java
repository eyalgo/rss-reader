package com.eyalgo.rssreader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eyalgo.rssreader.model.Item;
import com.google.common.collect.Lists;

@Service
public class RomeItemsExtractor implements ItemsExtractor {

    public RomeItemsExtractor() {
    }

    @Override
    public List<Item> extractItems(String feedUrl) {
	List<Item> result = Lists.newLinkedList();
	result.add(new Item("item 1 of " +feedUrl, feedUrl, null));
	result.add(new Item("item 2 of " +feedUrl, feedUrl, null));
	result.add(new Item("item 3 of " +feedUrl, feedUrl, null));
	return result;
    }

}
