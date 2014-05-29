package com.eyalgo.rssreader.dal;

import java.util.List;

import com.eyalgo.rssreader.model.Item;

public interface ItemsRepository {

	void saveItems(List<Item> items);

}
