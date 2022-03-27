package com.geneculling.javakata.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneculling.javakata.api.Timestamper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;


public class TimestamperServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(TimestamperServlet.class);

    TimestamperServlet(){

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("Embed Servlet received request");

        String cleanString = cleanDateFromPath(request.getPathInfo());

        Date date = Timestamper.getDateFromMillisecondsString(cleanString);
        response.getWriter().write(date.toString());
        response.flushBuffer();
    }

    private String cleanDateFromPath(String rawDate){
        return rawDate.substring(1);
    }

}
