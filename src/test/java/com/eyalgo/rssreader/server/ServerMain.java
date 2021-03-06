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
	    new JettyServer().start(8080);
	    LOGGER.info("Server started >>>");
	} catch (Exception e) {
	    LOGGER.error("Failed to start server.", e);
	}
    }
}