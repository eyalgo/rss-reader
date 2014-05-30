package com.eyalgo.rssreader.dal;

import com.eyalgo.rssreader.model.FeedData;

public interface ItemsRepository {
    void save(FeedData data);
}
