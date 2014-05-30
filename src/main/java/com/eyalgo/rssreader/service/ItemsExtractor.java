package com.eyalgo.rssreader.service;

import java.util.List;

import com.eyalgo.rssreader.model.Item;

public interface ItemsExtractor {

    List<Item> extractItems(String feedUrl);

}
