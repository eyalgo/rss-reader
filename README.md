# rss-reader
using ROME, Spring, Spring MVC and embedded Jetty

# Usage
## Run Jetty Embedded Plugin
Under 'test' directory, just java run ServerMain

## Show All
http://localhost:8080/rss/all

## Add RSS Entry
http://localhost:8080/rss/feed?feedUrl=http://feeds.feedburner.com/typepad/outbrain
http://localhost:8080/rss/feed?feedUrl=http://rss.cnn.com/rss/edition.rss
