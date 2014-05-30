package com.eyalgo.rssreader.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eyalgo.rssreader.model.FeedItem;
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
    public String addFeed(@RequestParam("feedUrl") String feedUrl) {
	System.out.println("add feed: " + feedUrl);
	feedReciever.addFeed(feedUrl);
	return "redirect:all";
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ModelAndView showAll() {
	List<FeedItem> items = itemsRetriever.get();
	ModelAndView modelAndView = new ModelAndView("rssItems");
	modelAndView.addObject("items", items);
	return modelAndView;
    }
}
