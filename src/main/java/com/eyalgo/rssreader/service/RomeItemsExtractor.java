package com.eyalgo.rssreader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eyalgo.rssreader.model.Item;
import com.google.common.collect.Lists;

@Service
public class RomeItemsExtractor implements ItemsExtractor {

	public RomeItemsExtractor() {
	}

	public List<Item> extractItems(String feedUrl) {
		return Lists.newLinkedList();
	}

}
