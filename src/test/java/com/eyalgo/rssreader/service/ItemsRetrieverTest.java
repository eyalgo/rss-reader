package com.eyalgo.rssreader.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eyalgo.rssreader.dal.ItemsRepository;
import com.eyalgo.rssreader.model.FeedItem;

@RunWith(MockitoJUnitRunner.class)
public class ItemsRetrieverTest {
    @Mock
    private ItemsRepository repository;

    private ItemsRetriever items;

    @Before
    public void setup() {
	items = new ItemsRetriever(repository);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenCallingForItems_shouldReturnItemsFromRepository() throws Exception {
	List<FeedItem> savedItems = mock(List.class, "saves items");
	when(repository.findAll()).thenReturn(savedItems);

	List<FeedItem> itemsRetrieved = items.get();
	assertThat(itemsRetrieved, is(savedItems));
    }
}
