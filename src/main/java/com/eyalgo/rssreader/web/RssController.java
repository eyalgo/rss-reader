package com.eyalgo.rssreader.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyalgo.rssreader.service.FeedReciever;

@Controller
@RequestMapping("/rss")
public class RssController {

    private final FeedReciever feedReciever;

    @Autowired
    public RssController(FeedReciever feedReciever) {
	this.feedReciever = feedReciever;
    }

    @RequestMapping(value = "feed", method = RequestMethod.GET)
    public void addFeed(@RequestParam("feedUrl") String feedUrl) {
	System.out.println("add feed: " + feedUrl);
	feedReciever.addFeed(feedUrl);
    }
}
