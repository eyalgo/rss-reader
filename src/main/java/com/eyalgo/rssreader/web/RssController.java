package com.eyalgo.rssreader.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eyalgo.rssreader.model.Item;
import com.eyalgo.rssreader.service.FeedReciever;
import com.eyalgo.rssreader.service.ItemsRetriever;

@Controller
@RequestMapping("/rss")
public class RssController {

    private final FeedReciever feedReciever;
    private final ItemsRetriever itemsRetriever;

    @Autowired
    public RssController(FeedReciever feedReciever, ItemsRetriever itemsRetriever) {
	this.feedReciever = feedReciever;
	this.itemsRetriever = itemsRetriever;
    }

    @RequestMapping(value = "feed", method = RequestMethod.GET)
    public void addFeed(@RequestParam("feedUrl") String feedUrl) {
	System.out.println("add feed: " + feedUrl);
	feedReciever.addFeed(feedUrl);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public String showAll() {
	List<Item> items = itemsRetriever.get();
	return "foo";
    }
}
