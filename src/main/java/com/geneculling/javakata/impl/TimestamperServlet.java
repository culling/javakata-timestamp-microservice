package com.geneculling.javakata.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class TimestamperServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(TimestamperServlet.class);

    TimestamperServlet(){

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("Embed Servlet received request");
        response.getWriter().write("TEST -2 ");
        response.flushBuffer();
    }

}
