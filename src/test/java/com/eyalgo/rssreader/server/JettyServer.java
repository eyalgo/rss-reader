// with the help of http://stas-blogspot.blogspot.co.il/2013/05/embedding-jetty9-spring-mvc.html

package com.eyalgo.rssreader.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class JettyServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JettyServer.class);
    private static final String WEB_APP_ROOT = "src/main/webapp";

    JettyServer() {
    }

    void start(int port) {
	WebAppContext webAppContext = createContext();
	Server server = new Server(port);
	server.setHandler(webAppContext);

	try {
	    server.start();
	} catch (Exception e) {
	    LOGGER.error("Failed to start server", e);
	    throw new RuntimeException();
	}

	LOGGER.info("Server started...");
    }

    private WebAppContext createContext() {
	WebAppContext webAppContext = new WebAppContext();
	webAppContext.setContextPath("/");
	webAppContext.setWar(WEB_APP_ROOT);
	return webAppContext;
    }
}
