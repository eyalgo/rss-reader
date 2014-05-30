package com.eyalgo.rssreader.service;

import java.util.List;

import com.eyalgo.rssreader.model.FeedItem;

public interface ItemsExtractor {

    List<FeedItem> extractItems(String feedUrl);

}
