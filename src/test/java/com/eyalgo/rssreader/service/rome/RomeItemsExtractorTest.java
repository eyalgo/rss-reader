package com.eyalgo.rssreader.service.rome;

import static com.eyalgo.rssreader.matchers.Matchers.sameFeedItem;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.rometools.fetcher.FeedFetcher;

import com.eyalgo.rssreader.model.FeedItem;
import com.eyalgo.rssreader.service.rome.RomeItemsExtractor;
import com.google.common.collect.Lists;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

@RunWith(MockitoJUnitRunner.class)
public class RomeItemsExtractorTest {
    @Mock
    private FeedFetcher fetcher;
    
    private RomeItemsExtractor extractor;

    @Before
    public void setup() {
	extractor = new RomeItemsExtractor(fetcher);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldReturnConvertedItemsFromFetcher() throws Exception {
	String feedUrl = "http://url.com";
	URL expectedUrl = new URL(feedUrl);
	List<SyndEntry> entries = Lists
		.newArrayList(entry("t1", "link1", new Date()), entry("t2", "link2", new Date()));
	SyndFeed feed = feed(entries);
	when(fetcher.retrieveFeed(eq(expectedUrl))).thenReturn(feed);
	List<FeedItem> extractedItems = extractor.extractItems(feedUrl);
	assertThat(extractedItems, containsInAnyOrder(sameFeedItem("t1", "link1"), sameFeedItem("t2", "link2")));
    }

    private SyndEntry entry(String title, String link, Date publishDate) {
	SyndEntry result = mock(SyndEntry.class);
	when(result.getTitle()).thenReturn(title);
	when(result.getLink()).thenReturn(link);
	when(result.getPublishedDate()).thenReturn(publishDate);
	return result;
    }

    private SyndFeed feed(List<SyndEntry> entries) {
	SyndFeed syndFeed = mock(SyndFeed.class);
	when(syndFeed.getEntries()).thenReturn(entries);
	return syndFeed;
    }
}
