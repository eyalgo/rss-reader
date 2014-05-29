package com.eyalgo.rssreader.dal;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eyalgo.rssreader.model.Item;

@Repository
public class InMemoryItemsRepository implements ItemsRepository {

	public InMemoryItemsRepository() {
	}

	public void saveItems(List<Item> items) {
	}

}
