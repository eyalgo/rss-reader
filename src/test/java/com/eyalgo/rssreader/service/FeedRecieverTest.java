package com.eyalgo.rssreader.service;

import static com.eyalgo.rssreader.matchers.Matchers.sameFeedData;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
public class FeedRecieverTest {
    private static final String FEED_URL = "the url";
    @Mock
    private ItemsExtractor extractor;
    @Mock
    private ItemsRepository repository;

    private FeedReciever reciever;

    @Before
    public void setup() {
	reciever = new FeedReciever(extractor, repository);
    }

    @Test
    public void whenGettingUrl_ThenShouldCallItemsExtractor() {
	reciever.addFeed(FEED_URL);
	verify(extractor).extractItems(FEED_URL);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldCallRepositoryWithOutputOfExtractor() {
	List<FeedItem> items = mock(List.class);
	when(extractor.extractItems(FEED_URL)).thenReturn(items);
	reciever.addFeed(FEED_URL);
	verify(repository).save(argThat(sameFeedData(FEED_URL, items)));
    }
}
