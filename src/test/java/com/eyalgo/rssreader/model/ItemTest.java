package com.eyalgo.rssreader.model;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import com.sun.syndication.feed.synd.SyndEntry;
public class ItemTest {
    @Test
    public void shouldSetFieldsOfSyndEntry() {
	String title = "this is the title";
	String link = "this is the link";
	Date publishedDate = mock(Date.class,"published date");
	
	SyndEntry feedEntry = mock(SyndEntry.class);
	when(feedEntry.getPublishedDate()).thenReturn(publishedDate);
	when(feedEntry.getTitle()).thenReturn(title);
	when(feedEntry.getLink()).thenReturn(link);
	
	Item item = Item.fromSyndEntry(feedEntry);
	assertNotNull(item);
	
	assertThat(item.getTitle(), equalTo(title));
	assertThat(item.getLink(), equalTo(link));
	assertThat(item.getPublishedDate(), equalTo(publishedDate));
    }
}
