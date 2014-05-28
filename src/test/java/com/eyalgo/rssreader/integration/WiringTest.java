package com.eyalgo.rssreader.integration;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eyalgo.rssreader.service.FeedReciever;
import com.eyalgo.rssreader.web.RssController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml",
	"file:src/main/webapp/WEB-INF/web-context.xml" })
public class WiringTest {

    @Mock
    private FeedReciever feedReciever;

    @Autowired
    private RssController controller;

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void shouldCallFeedReciever() {
	String feedUrl = "the URL";
	controller.addFeed(feedUrl);
	verify(feedReciever).addFeed(feedUrl);
    }

}
