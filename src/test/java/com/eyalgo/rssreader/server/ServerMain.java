package com.eyalgo.rssreader.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * @author Stas
 * @date 3/27/13
 */
public class ServerMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String args[]) throws Exception {
	SLF4JBridgeHandler.install();

	try {
	    JettyServer server = new JettyServer(8080);
	    server.start();
	    LOGGER.info("Server started");
	    server.join();
	} catch (Exception e) {
	    LOGGER.error("Failed to start server.", e);
	}
    }
}