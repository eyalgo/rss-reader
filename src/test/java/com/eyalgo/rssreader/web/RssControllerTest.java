package com.eyalgo.rssreader.web;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eyalgo.rssreader.service.FeedReciever;
import com.eyalgo.rssreader.service.ItemsRetriever;

@RunWith(MockitoJUnitRunner.class)
public class RssControllerTest {
    @Mock
    private FeedReciever feedReciever;
    @Mock
    private ItemsRetriever itemsRetriever;

    private RssController controller;

    @Before
    public void setup() {
	controller = new RssController(feedReciever, itemsRetriever);
    }

    @Test
    public void whenAddingFeedUrl_shouldCallFeedReciever() {
	String feedUrl = "the URL";
	controller.addFeed(feedUrl);
	verify(feedReciever).addFeed(feedUrl);
    }
    
    @Test
    public void whenCallingAll_shouldCallItemsRetriever() {
	controller.showAll();
	verify(itemsRetriever).get();
    }
}
