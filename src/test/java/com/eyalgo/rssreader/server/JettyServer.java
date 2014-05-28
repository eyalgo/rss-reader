// with the help of http://stas-blogspot.blogspot.co.il/2013/05/embedding-jetty9-spring-mvc.html

package com.eyalgo.rssreader.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

class JettyServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JettyServer.class);

    public static final String WEB_APP_ROOT = "src/main/webapp";
    public static final String MVC_SERVLET_NAME = "mvcDispatcher";
    public static final String JSP_SERVLET_NAME = "jspServlet";

    private final int port;

    private Server server;

    JettyServer(int port) {
	this.port = port;
    }

    void start() {
	server = new Server(port);
	server.setHandler(getServletHandler());

	try {
	    server.start();
	} catch (Exception e) {
	    LOGGER.error("Failed to start server", e);
	    throw new RuntimeException();
	}

	LOGGER.info("Server started");
    }

    private ServletContextHandler getServletHandler() {
	ServletHolder mvcServletHolder = new ServletHolder(MVC_SERVLET_NAME, new DispatcherServlet());
	mvcServletHolder.setInitParameter("contextConfigLocation", "web-context.xml");

	ServletHolder jspServletHolder = new ServletHolder(JSP_SERVLET_NAME, new org.apache.jasper.servlet.JspServlet());
	jspServletHolder.setInitParameter("keepgenerated", "true");
	jspServletHolder.setInitParameter("scratchDir", "views/generated");

	WebAppContext bb = new WebAppContext();
	bb.setServer(server);
	bb.setContextPath("/");
	bb.setWar(WEB_APP_ROOT);

	return bb;
    }

    void join() throws InterruptedException {
	server.join();
    }
}
