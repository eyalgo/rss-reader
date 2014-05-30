package com.eyalgo.rssreader.dal;

import java.util.List;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.Item;

public interface ItemsRepository {
    void save(FeedData data);

    List<Item> findAll();
}
