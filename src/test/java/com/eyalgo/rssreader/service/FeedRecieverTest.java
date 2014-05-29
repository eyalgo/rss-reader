package com.eyalgo.rssreader.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eyalgo.rssreader.dal.ItemsRepository;
import com.eyalgo.rssreader.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class FeedRecieverTest {
	private final String FEED_URL = "the url";
	@Mock
	private ItemsExtractor itemsExtractor;
	@Mock
	private ItemsRepository repository;
	
	@InjectMocks
	private FeedReciever reciever;
	
	@Test
	public void whenGettingUrl_ThenShouldCallItemsExtractor() {
		reciever.addFeed(FEED_URL);
		verify(itemsExtractor).extractItems(FEED_URL);
	}
	
	@SuppressWarnings("unchecked")
    @Test
	public void shouldCallRepositoryWithOutputOfExtractor() {
		List<Item> items = mock(List.class);
		when(itemsExtractor.extractItems(FEED_URL)).thenReturn(items);
		reciever.addFeed(FEED_URL);
		verify(repository).saveItems(items);
	}
}
