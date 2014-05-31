# rss-reader
A simple RSS reader that let's the user add RSS feeds and show them in the simplest way.
It is built using:
* ROME (for RSS)
* Spring (DI container)
* Spring MVC (simple REST and UI)
* Embedded Jetty (for rapid server development)

# Usage
## Run the server using Jetty Embedded Plugin
Under 'test' directory, execute the class ServerMain.java

## Show All
http://localhost:8080/rss/all

## Add RSS Entry
http://localhost:8080/rss/feed?feedUrl=http://feeds.feedburner.com/typepad/outbrain

http://localhost:8080/rss/feed?feedUrl=http://rss.cnn.com/rss/edition.rss

http://localhost:8080/rss/feed?feedUrl=https://bdaily.co.uk/feeds/technology-news.xml

# Resources
https://github.com/rometools/rome

https://github.com/rometools/rome-fetcher

http://www.eclipse.org/jetty/documentation/



