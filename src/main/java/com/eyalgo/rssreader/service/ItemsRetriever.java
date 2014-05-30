package com.eyalgo.rssreader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyalgo.rssreader.dal.ItemsRepository;
import com.eyalgo.rssreader.model.FeedItem;

@Service
public class ItemsRetriever {

    private ItemsRepository repository;

    @Autowired
    public ItemsRetriever(ItemsRepository repository) {
	this.repository = repository;
    }

    public List<FeedItem> get() {
	return repository.findAll();
    }

}
