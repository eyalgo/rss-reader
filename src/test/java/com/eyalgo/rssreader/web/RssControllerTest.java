package com.eyalgo.rssreader.web;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eyalgo.rssreader.service.FeedReciever;

@RunWith(MockitoJUnitRunner.class)
public class RssControllerTest {
    @Mock
    private FeedReciever feedReciever;

    private RssController controller;

    @Before
    public void setup() {
	controller = new RssController(feedReciever);
    }

    @Test
    public void shouldCallFeedReciever() {
	String feedUrl = "the URL";
	controller.addFeed(feedUrl);
	verify(feedReciever).addFeed(feedUrl);
    }
}
