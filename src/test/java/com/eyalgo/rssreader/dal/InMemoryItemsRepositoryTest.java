package com.eyalgo.rssreader.dal;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.eyalgo.rssreader.model.FeedData;
import com.eyalgo.rssreader.model.FeedItem;
import com.google.common.collect.Lists;

public class InMemoryItemsRepositoryTest {
    private InMemoryItemsRepository repository;

    @Before
    public void setup() {
	repository = new InMemoryItemsRepository();
    }

    @Test
    public void whenAddingFeedData_shouldGetBackAllItems() {
	String feedUrl = "url";
	FeedItem item1 = mock(FeedItem.class, "item 1");
	FeedItem item2 = mock(FeedItem.class, "item 2");
	FeedData data = new FeedData(feedUrl, Lists.newArrayList(item1, item2));

	repository.save(data);

	List<FeedItem> savedItems = repository.findAll();

	assertThat("should get all items from data", savedItems, containsInAnyOrder(item1, item2));
    }

    @Test
    public void whenAddingFeedDataFromDifferentUrls_shouldHaveItemsFromBothFeeds() {
	String feedUrl1 = "url";
	FeedItem item1 = mock(FeedItem.class, "item 1");
	FeedItem item2 = mock(FeedItem.class, "item 2");
	FeedData data1 = new FeedData(feedUrl1, Lists.newArrayList(item1, item2));
	repository.save(data1);

	String feedUrl2 = "url2";
	FeedItem item3 = mock(FeedItem.class, "item 3");
	FeedItem item4 = mock(FeedItem.class, "item 4");
	FeedData data2 = new FeedData(feedUrl2, Lists.newArrayList(item3, item4));

	repository.save(data2);

	List<FeedItem> savedItems = repository.findAll();

	assertThat("should get all items from both feeds", savedItems, containsInAnyOrder(item1, item2, item3, item4));
    }

    @Test
    public void whenSavingSameUrlWithDifferentItems_shouldOverrideOldItems() {
	String feedUrl = "url";
	FeedItem item1 = mock(FeedItem.class, "item 1");
	FeedItem item2 = mock(FeedItem.class, "item 2");
	List<FeedItem> items = Lists.newArrayList(item1, item2);
	FeedData data = new FeedData(feedUrl, items);

	repository.save(data);

	FeedItem item3 = mock(FeedItem.class, "item 3");
	FeedItem item4 = mock(FeedItem.class, "item 4");
	FeedData data2 = new FeedData(feedUrl, Lists.newArrayList(item3, item4));

	repository.save(data2);

	List<FeedItem> savedItems = repository.findAll();

	assertThat("should get newer items from same url", savedItems, containsInAnyOrder(item3, item4));

    }
}
